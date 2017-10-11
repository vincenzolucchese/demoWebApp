package com.vince.boot.demo.webapp.be.utility;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Clob;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Classe contenente i metodi di utilità relativi alla manipolazione dei
 * bean e delle loro proprietà.
 *
 * @author  Alessandro Vizzarro
 * @version 1.2.1
 * @comment 1.0.0  - aggiunti metodi: (Vizzarro)
 *                              containProperty(String[] excludedProperties,String property);
 *                              copyProperties(Object dest, Object source, String[] excludedProperties).
 * @comment 1.0.1  - aggiunto metodo copySimpleProperties(Object dest, Object source). (Verlengia)
 * @comment 1.0.3  - aggiunti metodi:  (Verlengia)
 *                              isSimpleType(Class clazz);
 *                              convertToString(Object source).
 * @comment 1.0.4  - aggiunto bugfix ai vari metodi di copia per evitare la trasformazione dei null in valori definiti. (Verlengia)
 * @comment 1.1.0  - aggiunti metodi di utilizzo comune per le proprietà di reflection. (Verlengia)
 * @comment 1.1.1  - riscritti per motivi prestazionali i metodi copyProperties e copySimpleProperties 
 *                              senza l'utilizzo delle commons.beanutils. (Verlengia)
 * @comment 1.2.0  - riscritto per motivi prestazionali il metodo copySimpleProperties implementando un sistema di caching
 * 								per il mapping delle proprietà. (Verlengia)
 * @comment 1.2.1  - modificato metodo copySimpleProperties per ottemperanza segnalazione CAST_186 (CAST_COMMONS). (Verlengia)
 *                   modificato metodo isSimpleTypes per ottemperanza segnalazione CAST_191 + CAST_192 (CAST_COMMONS). (Verlengia)
 *                   modificato metodo getMethod per ottemperanza segnalazione CAST_189 + CAST_190 (CAST_COMMONS). (Verlengia)
 *                   eliminati metodi copyPropertiesOld e copySimplePropertiesOld per ottemperanza segnalazione CAST_184 + CAST_185 + CAST_187 + CAST_188  (CAST_COMMONS). (Verlengia)
 *                   
 */
public class BeanUtility {

	/* Questo attributo statico viene usato come cache prestazionale per evitare il ripetuto ricalcolo di mapping di simpleproperties tra due classi già mappate in precedenza. */
	private static HashMap<Class<?>, HashMap<Class<?>,List<PropertyMapping>>> simplePropertiesMappingCache = new HashMap<Class<?>, HashMap<Class<?>,List<PropertyMapping>>> (0);
	
	/**
	 * Metodo che esegue all'interno della cache la ricerca di una copia già calcolata di un mapping di proprietà
	 * a partire da una coppia di classi (la prima classe indica il tipo di oggetto sorgente, mentre la seconda indica
	 * il tipo di oggetto destinazione).
	 * @param sourceClass la classe sorgente da usare come parte della chiave di ricerca
	 * @param destClass  la classe sorgente da usare come parte della chiave di ricerca
	 * @return mapping reprerito
	 */
	private static synchronized  List<PropertyMapping> findSimplePropertiesMappingCache(Class<?> sourceClass, Class<?> destClass) {
		if (!simplePropertiesMappingCache.containsKey(sourceClass)) return null;
		else return simplePropertiesMappingCache.get(sourceClass).get(destClass);
	}

	private synchronized static  void addSimplePropertiesCache(Class<?> sourceClass, Class<?> destClass, List<PropertyMapping> mappingList) {
		if(!simplePropertiesMappingCache.containsKey(sourceClass)) simplePropertiesMappingCache.put(sourceClass, new HashMap<Class<?>,List<PropertyMapping>>(0));
		simplePropertiesMappingCache.get(sourceClass).put(destClass,mappingList);
	}

	
	//aggiungere qui i Type da considerare come "semplici"
	@SuppressWarnings("rawtypes")
	private static Class[] simpleTypes = {String.class, Long.class, Integer.class, Date.class, Boolean.class, Clob.class, Float.class, Double.class, BigDecimal.class};
	
	/**
	 * Metodo che verifica se la classe passata come argomento è da considerarsi "semplice"
	 * ai fini della lavorazione con i metodi di utilità.
	 * @param clazz Classe da valutare.
	 * @return booleano che indica se la classe è "semplice".
	 */
	@SuppressWarnings("rawtypes")
	private static boolean isSimpleType(Class clazz){
		if(clazz.isPrimitive()) return true;
		
		for (int i=0;i<simpleTypes.length;i++) {
			if (clazz.equals(simpleTypes[i]) )return true; //CAST_191 + CAST_192 (CAST_COMMONS)
		}
		
		return false;
	}

	/**
	 * Metodo che verifica la presenza di una Stringa in un array specificato.
	 * @param excludedProperties Array di stringhe in cui eseguire la ricerca.
	 * @param property stringa da ricercare.
	 * @return boolean che assume valore vero se la stringa è stata trovata.
	 */
	private static boolean containProperty(String[] excludedProperties,String property){
		
		for (int i=0;i<excludedProperties.length;i++) {
			if (property.equals(excludedProperties[i]) )return true;
		}
		return false;
	}

	/**
	 * Metodo che copia tra due oggetti le proprietà aventi lo stesso nome.
	 * Permette di specificare un insieme di proprietà da escludere dal processo di copia.
	 * Questa è una versione custom del metodo che non utilizza le commons.beanutils ma un metodo custom
	 * ed è tendenzialmente più veloce.
	 * @param dest Oggetto destinazione.
	 * @param source Oggetto sorgente.
	 * @param excludedProperties Array di stringhe rappresentanti le proprietà da escludere dalla copia.
	 * @throws ApplicationException
	 */
	public static void copyProperties(Object dest, Object source, String[] excludedProperties) throws ApplicationException {
		for (Method m : source.getClass().getMethods()) {
			Object sourceValue = null;
			String methodName = m.getName();
			//consideriamo solo i getter
			if (isAccessor(m)) {
				//escludiamo le proprietà presenti nella lista delle esclusioni
				if (!BeanUtility.containProperty(excludedProperties, getAccessorFromField(methodName))) {
					//se esiste un corrispondente metodo setter sull'oggetto destinazione
					Method setter = getMethod(dest, getMutatorFromAccessor(methodName), m.getReturnType());
					if (setter != null && isMutator(setter)){
						sourceValue = invoke(source, m);
						//scartiamo i valori stringa nulla
						if (!(sourceValue != null && m.getReturnType().equals(String.class) && ((String) sourceValue).equals(""))) {
							invoke(dest, setter, sourceValue);
						}
					}				
				}
			}
		}
	}
	
	private static void addToMappingList (List<PropertyMapping> mappingList, Method m, Method setter) {
		mappingList.add(new PropertyMapping(m, setter));
	}
	
	/**
	 * Metodo che copia tra due oggetti tutte e sole le proprietà semplici aventi lo stesso nome.
	 * Permette di filtrare automaticamente tutte le proprietà che fanno riferimento ad oggetti "complessi".
	 * Il metodo copia solo gli oggetti appartenenti a classi di tipi primitivi o appartenenti ad un elenco specifico di
	 * classi considerate "semplici". 
	 * Questa è una versione custom del metodo che non utilizza le commons.beanutils ma un metodo custom
	 * ed una cache di mapping.
	 * @param dest Oggetto destinazione
	 * @param source Oggetto sorgente
	 * @throws ApplicationException
	 */
	public static void copySimpleProperties(Object dest, Object source) throws ApplicationException {
		Class<? extends Object> sourceClass = source.getClass();
		Class<? extends Object> destClass = dest.getClass();
		
		//cerca il mapping nella cache
		List<PropertyMapping> mappingList = findSimplePropertiesMappingCache(sourceClass, destClass);
		
		//seqione di logging commentata in quanto utile solo in fase di test prestazionale avanzato
//		if (mappingList == null) {
//			System.out.println("SimplePropertiesMappingCache: NON TROVATO mapping "+sourceClass+" - "+destClass);
//		}
//		else {
//			System.out.println("SimplePropertiesMappingCache: TROVATO mapping "+sourceClass+" - "+destClass);
//		}
		
		//se non ha trovato il mapping lo genera
		if (mappingList == null) {
			mappingList = new ArrayList<PropertyMapping>(0);
			for (Method m : source.getClass().getMethods()) {
				String methodName = m.getName();
				//consideriamo solo i getter
				if (isAccessor(m)) {
					//se esiste un corrispondente metodo setter sull'oggetto destinazione
					Method setter = getMethod(dest, getMutatorFromAccessor(methodName), m.getReturnType());
					if (setter != null && isMutator(setter)){
						//copiamo solo i valori semplici
						if (isSimpleType(m.getReturnType())) {
							//mappingList.add(new PropertyMapping(m, setter)); //CAST_186: CAST_COMMONS
							addToMappingList(mappingList, m, setter);
						}
					}
				}
			}
			//aggiunge la lista di mapping alla cache
			addSimplePropertiesCache(sourceClass, destClass, mappingList);
		}
		
		//utilizza il mapping per copiare i dati tra gli oggetti
		for (PropertyMapping pM : mappingList) {
			Method getter = pM.getAccessor();			
			Method setter = pM.getMutator();
			Object sourceValue = null;
			sourceValue = invoke(source, getter);
			//scartiamo i valori stringa nulla
			if (!(sourceValue != null && getter.getReturnType().equals(String.class) && ((String) sourceValue).equals(""))) {
				invoke(dest, setter, sourceValue);
			}
		}		
	}

	/**
	 * Metodo che genera in maniera dinamica una versione toString di un oggetto generico
	 * contenente un elenco di tutte le sue proprietà semplici.
	 * Nota1: il metodo è piuttosto oneroso e se ne sconsiglia l'utilizzo in ambiente di produzione.
	 * Nota2: in alternativa a questo metodo è possibile utilizzare la classe gov.mef.commons.business.util.StringFriendly
	 * estendendo la classe da rappresentare sottoforma di stringa e poi utilizzando il normale metodo toString().
	 * @param source Oggetto da convertire
	 * @return Stringa contenente la versione testuale dell'oggetto
	 * @throws ApplicationException
	 * 
	 * @see gov.mef.commons.business.util#StringFriendly
	 */
	public static String convertToString(Object source) throws ApplicationException {
		return null;
		
//		String stringObject  = ">>>> " +source.getClass().getSimpleName()+ "[";
//		try {
//			PropertyDescriptor[] props = PropertyUtils.getPropertyDescriptors(source);
//			for (int i = 0; i < props.length; i++) {
//				String propName = props[i].getName();
//				if (BeanUtility.isSimpleType(props[i].getPropertyType())) {
//					Object propValue = PropertyUtils.getProperty(source, propName); 
//					stringObject +=  propName + " = " + propValue;
//					if (i<props.length-1) { stringObject +=  "; "; }
//				}
//				
//			}
//		} catch (IllegalAccessException e) {
//			ApplicationException ne =new ApplicationException("BeanUtils readproperty error.");
//		    ne.initCause(e);
//		    throw ne;
//		} catch (InvocationTargetException e) {
//			ApplicationException ne =new ApplicationException("BeanUtils readproperty error.");
//		    ne.initCause(e);
//		    throw ne;
//		} catch (NoSuchMethodException e) {
//			ApplicationException ne =new ApplicationException("BeanUtils readproperty error.");
//		    ne.initCause(e);
//		    throw ne;
//		}
//		
//		stringObject  += "] <<<<<";
//		return stringObject;
	}

	public static String getAccessorFromField(String fieldName) {
		return "get"+fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
	}

	public static String getMutatorFromField(String fieldName) {
		return "set"+fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
	}

	public static String getMutatorFromAccessor(String methodName) {
		return "set"+methodName.substring(3);
	}

	public static String getAccessorFromMutator(String methodName) {
		return "get"+methodName.substring(3);
	}
	
	public static String getFieldFromAccessor(String methodName) {
		if (methodName.startsWith("is")) { return methodName.substring(2, 4).toLowerCase() + methodName.substring(4);}
		if (methodName.startsWith("get")) { return methodName.substring(3, 5).toLowerCase() + methodName.substring(5);}
		return null;
	}
	
	public static String getFieldFromMutator(String methodName) {
		if (methodName.startsWith("set")) { return methodName.substring(3, 5).toLowerCase() + methodName.substring(5);}
		return null;
	}
	
	public static boolean isAccessor(String methodName) {
		return (methodName.startsWith("get") || methodName.startsWith("is"));
	}
	
	public static boolean isAccessor(Method method) {
		return isAccessor(method.getName());
	}
	
	public static boolean isMutator(String methodName) {
		return (methodName.startsWith("set"));
	}
	
	public static boolean isMutator(Method method) {
		return isMutator(method.getName());
	}
	
	public static Object invoke(Object object, Method method, Object ... args) throws ApplicationException {
		try {
			return method.invoke(object, args);
		} catch (IllegalArgumentException e) {
			throw new ApplicationException(e);
		} catch (IllegalAccessException e) {
			throw new ApplicationException(e);
		} catch (InvocationTargetException e) {
			throw new ApplicationException(e);
		}
	}
	
	public static Method getMethod(Class<?> clazz, String methodName, Class<?>... parameterTypes) {
		Method m = null;
		try {
			m = clazz.getMethod(methodName, parameterTypes);
		} catch (SecurityException e) { m = null; } catch (NoSuchMethodException e) { m = null; } //CAST_189 + CAST_190 (CAST_COMMONS)
		return m;
	}
	
	public static Method getMethod(Object object, String methodName, Class<?>... parameterTypes) {
		return getMethod(object.getClass(), methodName, parameterTypes);
	}
	
	public static void setValueInObjectField(Object destObject, String fieldName, Object valueObject) throws ApplicationException {
		invoke(destObject, getMethod(destObject, getMutatorFromField(fieldName), valueObject.getClass()), valueObject);
	}
	
	public static Object getValueFromObjectField(Object sourceObject, String fieldName) throws ApplicationException {
		return invoke(sourceObject, getMethod(sourceObject, getAccessorFromField(fieldName)));
	}
}
