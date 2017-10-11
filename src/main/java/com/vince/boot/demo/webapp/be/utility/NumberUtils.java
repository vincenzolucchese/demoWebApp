package com.vince.boot.demo.webapp.be.utility;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;

/**
 * Classe che espone funzioni di utilità legate alle URL.
 * 
 * @author Simone Verlengia
 * @version 1.0.3
 * @comment 1.0.1 Aggiunto metodo isLong(). (Verlengia)
 * @comment 1.0.2 Rivisti ed ampliati tutti i metodi di parsing e controllo dei numeri per gestire il formato italiano.
 * @comment 1.0.3 aggiunti metodi di formattazione in stringa.
 */
//TODO: ALLINEARE ALTRI VERTICALI
public class NumberUtils {
	private static final String REGEX_ONLY_DIGIT = "[0-9]+";
	private static final Locale defaultLocale = Locale.ITALIAN;
	
	/**
	 * Metodo che estrae da una string la parte intera di un decimale (lo restituisce sottoforma di Long). 
	 * NOTA: il metodo NON verifica che la stringa contenga un decimale valido.
	 * @param s stringa da cui estrarre la parte intera.
	 * @return Long estratto
	 */
	public static Long extractIntegerPartFromFixedDecimalString(String s) {
		int decimalPosition = s.indexOf(',');
		if (decimalPosition < 0) {
			return new Long(s);
		}
		return new Long(s.substring(0, decimalPosition));
	}
	
	/**
	 * Metodo che esgue il parsing di una stringa in un Long. 
	 * Si presume che la stringa contenga un intero scritto secondo lo standard italiano (col separatore dei decimali "," ed eventuali separatori di migliaia con ".").
	 * @param input stringa da parsare
	 * @return oggetto Long risultante dal parsing
	 * @throws NumberFormatException se la stringa non è parsabile in Long.
	 */
	public static Long parseLong(String input) throws NumberFormatException {
		Long result = null;
		try {
			result = parseBigDecimal(input).longValueExact();
		}
		catch(ArithmeticException e) {
        	throw new NumberFormatException("Il valore '"+input+"' non è un numero Long valido.");
		}
		return result;
	}
	
	/**
	 * Metodo che esgue il parsing di una stringa in un Long. 
	 * Si presume che la stringa contenga un intero scritto secondo lo standard italiano (col separatore dei decimali "," ed eventuali separatori di migliaia con ".").
	 * @param input stringa da parsare
	 * @return oggetto Long risultante dal parsing
	 * @throws NumberFormatException se la stringa non è parsabile in Long.
	 */
	public static Integer parseInteger(String input) throws NumberFormatException {
		Integer result = null;
		try {
			result = parseBigDecimal(input).intValueExact();
		}
		catch(ArithmeticException e) {
        	throw new NumberFormatException("Il valore '"+input+"' non è un numero Integer valido.");
		}
		return result;
	}
	
	/**
	 * Metodo che esgue il parsing di una stringa in un BigDecimal. 
	 * Si presume che la stringa contenga un decimale scritto secondo lo standard italiano (col separatore dei decimali "," ed eventuali separatori di migliaia con ".").
	 * @param input stringa da parsare
	 * @return oggetto BigDecimal risultante dal parsing
	 * @throws NumberFormatException se la stringa non è parsabile in BigDecimal.
	 */
	public static BigDecimal parseBigDecimal(String input) throws NumberFormatException {
        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance(defaultLocale);
        df.setParseBigDecimal(true);
        ParsePosition pp = new ParsePosition(0);
        BigDecimal result = (BigDecimal) df.parseObject(input, pp);
        if (result == null || pp.getIndex() != input.length()) {
        	throw new NumberFormatException("Il valore '"+input+"' non è un numero BigDecimal valido.");
        }
        return result;
	}
	
	/**
	 * Controlla che la stringa passata in input sia convertibile in un Long.
	 * Si presume che la stringa possa contenere i separatori di migliaia secondo lo standard italiano (".").
	 * @param input stringa da controllare.
	 * @return <code>true</code> se la condizione è verificata, altrimenti <code>false</code>.
	 */
	public static boolean isLong(String input) {
		try {
			parseLong(input);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Controlla che la stringa passata in input sia convertibile in un Integer.
	 * Si presume che la stringa possa contenere i separatori di migliaia secondo lo standard italiano (".").
	 * @param input stringa da controllare.
	 * @return <code>true</code> se la condizione è verificata, altrimenti <code>false</code>.
	 */
	public static boolean isInteger(String input) {
		boolean ret = true;
		
		try {
			parseInteger(input);
		} catch (NumberFormatException e) {
			ret = false;
		}
		
		return ret;
	}
	
	/**
	 * Controlla che la stringa passata in input sia un numero convertibile in un BigDecimal.</br>
	 * Si presume che la stringa contenga un decimale scritto secondo lo standard italiano (col separatore dei decimali "," ed eventuali separatori di migliaia con ".").
	 * 
	 * @param input stringa da controllare.
	 * @return <code>true</code> se la condizione è verificata, altrimenti <code>false</code>.
	 */
	public static boolean isBigDecimal(String s) {
		try {
			parseBigDecimal(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Controlla che la stringa passata in input sia un numero intero valido (privo quindi di parte decimale).</br>
	 * Si presume che la stringa contenga un numero intero scritto secondo lo standard italiano (eventuali separatori di migliaia con ".").
	 * 
	 * @param input stringa da controllare.
	 * @return <code>true</code> se la condizione è verificata, altrimenti <code>false</code>.
	 */
	public static boolean isWholeNumber(String s) {
		boolean result = true;
		try {
			BigDecimal bd = parseBigDecimal(s);
			if (bd.scale()>0) {
				bd.toBigIntegerExact();
			}
		} catch (ArithmeticException e) {
			result = false;
		} catch (NumberFormatException e) {
			result = false;
		}
		return result;
	}
	
	/**
	 * Controlla che la stringa passata in input contenga solo caratteri numerici.</br>
	 * 
	 * @param input stringa da controllare.
	 * @return <code>true</code> se la condizione è verificata, altrimenti <code>false</code>.
	 */
	public static boolean isOnlyDigit(String input) {
		return input.matches(REGEX_ONLY_DIGIT);
	}
	
	/**
	 * Metodo che converte un valore espresso in byte in MegaByte. Il metodo
	 * lavora con valori {@link String}.
	 * 
	 * @param valore
	 *            valore espresso in byte
	 * @return valore convertito in Megabyte
	 */
	public static String convertiByteinMegaByte(String valore) {
		BigDecimal valoreDecimale = new BigDecimal(valore);
		MathContext mc = new MathContext(3, RoundingMode.HALF_UP);
		BigDecimal divisore = new BigDecimal(1048576);
		valoreDecimale = valoreDecimale.divide(divisore, mc);
	
		valore = valoreDecimale.toString();
		valore = valore.replace(".", ",");
	
		return valore;
	}

	/**
	 * Metodo che conta il numero di cifre intere (significative) di un BigDecimal.
	 * @param n valore BigDecimal.
	 * @return int pari al numero di cifre intere (significative).
	 */
	public static int integerDigits(BigDecimal n) {
	    return n.signum() == 0 ? 1 : n.precision() - n.scale(); //viene prima controllato se vale zero, per motivi prestazionali.
	}
	
	/**
	 * Metodo che conta il numero di cifre decimali (significative) di un BigDecimal.
	 * @param n valore BigDecimal.
	 * @return int pari al numero di cifre decimali (significative).
	 */
	public static int decimalDigits(BigDecimal n) {
		return Math.max(0, n.stripTrailingZeros().scale()); //nel caso lo scale sia negativo restituisce comunque 0.
	}
	
	/**
	 * Metodo che formatta in stringa un oggetto Number e permette di specificare alcune opzioni di formattazione.
	 * Al momento utilizza implicitamente il locale.ITALIAN.
	 * @param input oggetto Number da convertire in stringa.
	 * @param groupingUsed flag che indica se vanno rappresentati i separatori di migliaia (se impostato a null il default è true).
	 * @param minimumIntegerDigits flag che il numero minimo di cifre della parte intera (se impostato a null il default è 0).
	 * @param maximumIntegerDigits flag che il numero massimo di cifre della parte intera (se impostato a null il default è 309).
	 * @param minimumFractionDigits flag che il numero minimo di cifre della parte decimale (se impostato a null il default è 0).
	 * @param maximumFractionDigits flag che il numero massimo di cifre della parte decimale (se impostato a null il default è 340).
	 * @return stringa contenente la rappresentazione testuale (formattata) del numero.
	 */
	public static String formatNumber(Number input, Boolean groupingUsed,
			Integer minimumIntegerDigits, Integer maximumIntegerDigits, 
			Integer minimumFractionDigits, Integer maximumFractionDigits) {
		if(input==null) { return null; }
		
		DecimalFormat df = (DecimalFormat) NumberFormat.getInstance(defaultLocale);
		
		df.setMinimumIntegerDigits(Utils.coalesce(minimumIntegerDigits,1));
		df.setMaximumIntegerDigits(Utils.coalesce(maximumIntegerDigits,309));
		df.setMinimumFractionDigits(Utils.coalesce(minimumFractionDigits,0));
		df.setMaximumFractionDigits(Utils.coalesce(maximumFractionDigits,340));
		df.setGroupingUsed(Utils.coalesce(groupingUsed, true));
		df.setDecimalSeparatorAlwaysShown(false);
		
		return df.format(input);		
	}
	
	/**
	 * Metodo che formatta in stringa un oggetto Number applicando alle opzioni di formattazione i valori standard.
	 * Al momento utilizza implicitamente il locale.ITALIAN.
	 * @param input oggetto Number da convertire in stringa.
	 * @return stringa contenente la rappresentazione testuale (formattata) del numero.
	 */
	public static String formatNumber(Number input) {
		return formatNumber(input, null,null, null, null, null);
	}
	
	/********************
	 * METODI DEPRECATI *
	 ********************/
	
	/**
	 * Metodo che estrae da una string la parte intera di un decimale (lo restituisce sottoforma di Long). 
	 * NOTA: il metodo NON verifica che la stringa contenga un decimale valido.
	 * @param s stringa da cui estrarre la parte intera.
	 * @return Long estratto
	 * @deprecated utilizzare invece il metodo {@link #convertFixedDecimalStringToLong(String s)}
	 */
	@Deprecated
	public static Long convertFixedDecimalToLong(String s) {
		return extractIntegerPartFromFixedDecimalString(s);
	}
	
	/**
	 * Metodo che esgue il parsing di una stringa in un BigDecimal. 
	 * Si presume che la stringa contenga un decimale scritto secondo lo standard italiano (col separatore dei decimali "," ed eventuali separatori di migliaia con ".").
	 * @param s stringa da parsare
	 * @return oggetto BigDecimal risultante dal parsing
	 * @deprecated utilizzare invece il metodo {@link #parseBigDecimal(String s)}
	 */
	@Deprecated
	public static BigDecimal stringToBigDecimal(String s) throws NumberFormatException {
		return parseBigDecimal(s);
	}
	
	/**
	 * Metodo che esgue il parsing di una stringa in un BigDecimal. 
	 * Si presume che la stringa contenga un decimale scritto secondo lo standard italiano (col separatore dei decimali "," ed eventuali separatori di migliaia con ".").
	 * @param s stringa da parsare
	 * @return oggetto BigDecimal risultante dal parsing
	 * @deprecated utilizzare invece il metodo {@link #parseBigDecimal(String s)}
	 */
	public static BigDecimal convertFixedDecimalToBigDecimal(String s)  throws NumberFormatException {
		return parseBigDecimal(s);
	}

	public static void main(String args[]) {
		BigDecimal n = new BigDecimal("0.0001");
		System.out.println(formatNumber(n, null, null, null, null, null));
	}
	
	
}
