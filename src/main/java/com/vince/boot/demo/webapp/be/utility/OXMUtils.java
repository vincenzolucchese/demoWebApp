package com.vince.boot.demo.webapp.be.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class OXMUtils {
	
	private final static String separatoreStandard = " : ";
	
	public static String getSeparatorestandard() {
		return separatoreStandard;
	}
	
	public static String convertIdToString(Long id) {
		return "("+id.toString()+")"; 
	}
	
	public static String convertStringIdToString(String id) {
		return "("+id.toString()+")"; 
	}
	
	/**
	 * Controlla se una stringa contiene un numero tra parentesi o, altrimenti,
	 * se la stringa rappresenta essa stessa un numero. 
	 *
	 * @param string La stringa da esaminare
	 *
	 * @return il numero trovato se la stringa lo contiene tra parentesi o se la
	 * stringa stessa è un numero, altrimenti restituisce -1
	 */
	public static Long findId(String string) {
		Long id;
		//in prima battuta cerca il codice numerico fra parentesi
		Pattern pattern = Pattern.compile("[(][0-9]+[)][\\s]*$");
		Matcher matcher = pattern.matcher(string);
		if (matcher.find()) {
			int start = matcher.start();
			int end = matcher.end();
			String match = string.substring(start+1, end-1);
			try {
				id = Long.valueOf(match);
			} catch (NumberFormatException e) {id = new Long(-1);} //CAST_195 + CAST_196 (CAST_COMMONS)
		}
		//altrimenti cerca di interpretare l'intera stringa come valore numerico
		else {
			try {
				id = Long.valueOf(string);
			} catch (NumberFormatException e) {id = new Long(-1);} //CAST_195 + CAST_196 (CAST_COMMONS)
		}
		return id;
	}
	
	/**
	 * Controlla se una stringa contiene un valore alfanumerico tra parentesi.
	 *
	 * @param string La stringa da esaminare
	 *
	 * @return il valore alfanumerico se la stringa lo contiene tra parentesi,
	 * altrimenti restituisce la stringa stessa
	 */
	public static String findStringId(String string) {
		String id = "";
		//in prima battuta cerca il codice alfanumerico fra parentesi
		Pattern pattern = Pattern.compile("[(][^()]+[)][\\s]*$");
		Matcher matcher = pattern.matcher(string);
		if (matcher. find()) {
			int start = matcher.start();
			int end = matcher.end();
			String match = string.substring(start+1, end-1);
			id = match.trim();
		}
		//altrimenti interpreta l'intera stringa come codice alfanumerico		
		else {
			id = string;
		}
		return id;
	}
	
	public static String findComuneFromLocalizzazioneGeografica(String string) {
		String id= "";
		Pattern pattern = Pattern.compile("^.*[\\[]");
		Matcher matcher = pattern.matcher(string);
		if (matcher.find()) {
			int start = matcher.start();
			int end = matcher.end();
			String match = string.substring(start, end-1);				
			id = match.trim();
		}
		return id;
	}
	
	public static String findCapFromLocalizzazioneGeografica(String string) {
		String id= "";
		Pattern pattern = Pattern.compile("[\\[].+[\\]]");
		Matcher matcher = pattern.matcher(string);
		if (matcher.find()) {
			int start = matcher.start();
			int end = matcher.end();
			String match = string.substring(start+1, end-1);				
			id = match.trim();
		}
		return id;
	}
	
	public static String optionallyEncapsulateString(String string) {
		String result= null;
		Pattern pattern = Pattern.compile("^[0-9,\\./]*$");
		Matcher matcher = pattern.matcher(string);
		//se ha trovato un valore presumibilmente numerico che inizia per 0 lo encapsula per renderlo apribile anche da excel
		if (matcher.matches()) {
			result = "[" + string + "]"; 
		}
		//altrimenti lo lascia immutato
		else {
			result = string;
		};
		return result;
	}
	
	public static String getOptionallyEncapsulatedString(String string) {
		String result= "";
		Pattern pattern = Pattern.compile("^[\\[].*[\\]]$");
		Matcher matcher = pattern.matcher(string);
		//se ha trovato un valore incapsulato elimina i delimitatori
		if (matcher.find()) {
			int start = matcher.start();
			int end = matcher.end();
			String match = string.substring(start+1, end-1);				
			result = match.trim();
		}
		//altrimenti lo lascia immutato
		else {
			result = string;
		};
		
		return result;
	}
	
	public static String removeLeadingZerosFromNumericString(String string) {
		if (string.matches("^[0-9]+$"))
		{ 
			string= string.replaceFirst("^0+(?!$)", "");
		}
		return string;
	}
	
	public static void main(String args[]) {
		System.out.println("@@@"+findComuneFromLocalizzazioneGeografica("Roma (RM) [00139]")+"###");
		System.out.println("@@@"+findCapFromLocalizzazioneGeografica("Roma (RM) [00139]")+"###");
		System.out.println("@@@"+findStringId("prova (id-stringa)")+"###");
		System.out.println("@@@"+findId("prova (01234)")+"###");
		System.out.println("@@@"+optionallyEncapsulateString("0123,4")+"###");		
		System.out.println("@@@"+getOptionallyEncapsulatedString("[00312600372]")+"###");
		System.out.println("@@@"+removeLeadingZerosFromNumericString("01")+"###");
		System.out.println("@@@"+removeLeadingZerosFromNumericString("01a")+"###");
	}
}
