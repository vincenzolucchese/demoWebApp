package com.vince.boot.demo.webapp.be.utility;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.text.ParseException;

/**
 * Classe che espone funzioni di utilità legate alle stringhe.
 * 
 * @author Simone Verlengia
 * @version 1.2.0
 * @comment 1.1.0 Aggiunto metodo isValidCodiceFiscaleAzienda (Verlengia)
 * @comment 1.2.0 Aggiunti metodi convertAccentToApostrophe, normalizeItalianCityName, upperCaseItalianCityName. (Verlengia)
 * @comment 1.2.1 Aggiunti metodi {@link #isSubstantiallyEqual(String, String)} e {@link #removeAccent(String)}. (Verlengia)
 */
public class StringUtils {
	
	StringUtils() {
		throw new IllegalAccessError("Utility class");
	}
	
	private static String REGEXP_INTEGER = "^(\\d+)$";
	
	/**
	 * Metodo che confronta due stringhe e verifica se sono sostanzialmente identiche.
	 * Nel corso del confronto vengono ignorate le differenze di maiuscolo/minuscolo, 
	 * i caratteri accentati inoltre i caratteri di spaziatura e gli apici singoli/doppi
	 * vengono compressi.
	 * @param a prima stringa da confrontare
	 * @param b seconda stringa da confrontare
	 * @return true se sono sostanzialmente uguali, false altrimenti.
	 */
	public static boolean isSubstantiallyEqual(String a, String b) {
		if (a==null) {
			return (b==null); //se sono entrambe null ritorna true, false altrimenti.
		}
		else if (b==null)
			return false;
		
		String a1 = removeAccent(a).replaceAll("[\\s'\"]+"," ").trim();
		String b1 = removeAccent(b).replaceAll("[\\s'\"]+"," ").trim();
		
		return a1.equalsIgnoreCase(b1);
	}
	
	/**
	 * Metodo che esegue una trim su una stringa in modo tale che risulti lunga
	 * al massimo un certo numero di byte secondo la codifica UTF-8.
	 * 
	 * @param originalString
	 *            stringa originale
	 * @param maxBytesLength
	 *            numero di byte massimi
	 * @return stringa risultante dopo l'operazione di trim
	 */
	public static String trimUTF8String(final String originalString,
			final long maxBytesLength) {
	
		if (originalString == null
				|| StringUtils.getUtf8Length(originalString) <= maxBytesLength) {
			return originalString;
		}
		int newBytesLength = 0;
		String outString = "";
		String newChar;
		for (int i = 0; i < originalString.length(); i++) {
			newChar = originalString.substring(i, i + 1);
			newBytesLength += StringUtils.getUtf8Length(newChar);
			if (newBytesLength > maxBytesLength) {
				break;
			}
			outString += newChar;
		}
		return outString;
	}

	/**
	 * Metodo che calcola la lunghezza di una stringa in byte secondo la
	 * codifica UTF-8.
	 * 
	 * @param value
	 *            stringa di cui calcolare la lunghezza
	 * @return long contenente la lunghezza calcolata
	 */
	public static long getUtf8Length(String value) {
	
		final Charset utf8Charset = Charset.forName("UTF-8");
		return value.getBytes(utf8Charset).length;
	}

	/**
	 * Metodo che converte una stringa rimpiazzando gli eventuali caratteri
	 * seguiti da apostrofo in corrispondenti caratteri accentati minuscoli.
	 * Converte inoltre le "é" in "è".
	 * 
	 * @param str
	 *            stringa di input
	 * @return stringa convertita
	 */
	public static String convertApostrophe(String str) {
		String newStr = "";
		if (str == null)
			return null;
	
		newStr = str.replace("a'", "à");
		newStr = newStr.replace("A'", "à");
		newStr = newStr.replace("e'", "è");
		newStr = newStr.replace("E'", "è");
		newStr = newStr.replace("i'", "ì");
		newStr = newStr.replace("I'", "ì");
		newStr = newStr.replace("o'", "ò");
		newStr = newStr.replace("O'", "ò");
		newStr = newStr.replace("u'", "ù");
		newStr = newStr.replace("U'", "ù");
	
		return newStr;
	}
	
	/**
	 * Metodo che converte una stringa rimuovendo eventuali caratteri accentati 
	 * (vengono convertiti in caratteri normali) ed eventuali apostrofi "'" usati 
	 * a mo' di possibile accento (solo quelli che seguono le vocali).
	 * @param stringa di input
	 * @return stringa convertita
	 */
	public static String removeAccent(String str) {
		String newStr = "";
		if (str == null)
			return null;
		
		newStr = str.replaceAll("a'|à", "a");
		newStr = newStr.replaceAll("A'|À", "A");
		newStr = newStr.replaceAll("e'|è|é", "e");
		newStr = newStr.replaceAll("E'|È|É", "E");
		newStr = newStr.replaceAll("i'|ì", "i");
		newStr = newStr.replaceAll("I'|Ì", "I");
		newStr = newStr.replaceAll("o'|ò", "o");
		newStr = newStr.replaceAll("O'|Ò", "O");
		newStr = newStr.replaceAll("u'|ù", "u");
		newStr = newStr.replaceAll("U'|Ù", "U");
	
		return newStr;
	}
	
	/**
	 * Metodo che converte una stringa rimpiazzando gli eventuali caratteri
	 * accentati in lettere corrispondenti seguite dall'apostrofo.
	 * Converte inoltre le "é" in "è".
	 * 
	 * @param str
	 *            stringa di input
	 * @return stringa convertita
	 */
	public static String convertAccentToApostrophe(String str) {
		String newStr = "";
		if (str == null)
			return null;
	
		newStr = str.replace("à", "a'");
		newStr = newStr.replace("À", "A'");
		newStr = newStr.replace("è", "e'");
		newStr = newStr.replace("È", "E'");
		newStr = newStr.replace("é", "e'");
		newStr = newStr.replace("É", "e'");
		newStr = newStr.replace("ì", "i'");
		newStr = newStr.replace("Ì", "I'");
		newStr = newStr.replace("ò", "o'");
		newStr = newStr.replace("Ò", "O'");
		newStr = newStr.replace("ù", "u'");
		newStr = newStr.replace("Ù", "U'");
	
		return newStr;
	}
	

	/**
	 * Metodo che individua la validità di una stringa come indirizzo email.
	 * Questo metodo applica quasi integralmente la RFC relativa alle regole di
	 * validità degli indirizzi email. Non gestisce tuttavia gli indirizzi con
	 * domain riportato sottoforma di IP numerico e non gestisce le email con
	 * parte locale contenente stringhe quotate ["stringa"] e commenti racchiusi
	 * fra parentesi [(commento)].
	 * 
	 * @param value stringa da verificare.
	 * @return ritorna <code>true</code> se la stringa è valida, altrimenti <code>false</code>.
	 */
	public static boolean isValidSingleEmailAddress(String value) {
		if (value == null)
			return false;
	
		// L'email deve essere lunga massimo 257 caratteri (256 caratteri più il simbolo "@").
		if (value.length() > 256)
			return false;
	
		// Caratteri ammissibili nella parte local dell'indirizzo (parte prima della "@").
		String localChar = "[\\w\\-\\^!#$%&'*+/=?`{|}~]";
	
		/*
		 * Sottoespressione regolare che individua le possibili label valide presenti nel domain
		 * (cioè i token presenti dopo la "@" e separati fra loro dal ".").
		 */
		String domainLabel = "(([A-Za-z0-9]([A-Za-z0-9\\-])*[A-Za-z0-9])|([A-Za-z0-9]))";
	
		/*
		 * Sottoespressione regolare che individua i valori validi per l'ultima label presente nel domain.
		 */
		String lastDomainLabel = "(([A-Za-z0-9]([A-Za-z0-9\\-])*[A-Za-z0-9]))";
		
		if (!value.matches("^" + localChar + "+(\\." + localChar + "+)*@"
				+ domainLabel + "(\\." + domainLabel + ")*(\\."
				+ lastDomainLabel + ")$"))
			return false;
	
		// Il domain non deve terminare con una label solo numerica
		if (value.matches("^.*\\.[0-9]*$"))
			return false;
	
		String tokens[] = value.split("@");
		String local = tokens[0];
		String domain = tokens[1];
	
		// La parte local (prima la @) deve essere lunga massimo 60 caratteri)
		if (local.length() > 64)
			return false;
	
		// La parte domain (dopo la @) deve essere lunga massimo 255 caratteri)
		if (domain.length() > 255)
			return false;
	
		String labels[] = domain.split("\\.");
	
		/*
		 * TODO verificare da RFC la possibile lunghezza della ultima label del
		 * domain sia compresa tra 2 e 4
		 */
		if ((labels[labels.length - 1].length() < 2)
				|| (labels[labels.length - 1].length() > 4))
			return false;
	
		// Nessuna label non può essere lunga più di 63 caratteri
		for (String label : labels) {
			if (label.length() > 63)
				return false;
		}
	
		return true;
	
		/*
		 * RFC Requirements An email address must consist of a local part and a
		 * domain part separated by an @ symbol (x40) with a combined length of
		 * no more than 256 characters. - RFC 3696 - 3 & errata, RFC 2822 -
		 * 3.4.1
		 * 
		 * Local Part:
		 * 
		 * A non-quoted local part may consist of alpha (a-z) (x61-x7A) (A-Z)
		 * (x41-x5A), numeric (0-9) (x30-x39) and the following characters:
		 * !#$%&'*+-/=?^_`{|}~ (x21, x23, x24, x25, x26, x27, x2A, x2B, x2D,
		 * x2F, x3D, x3F, x5E, x5F, x60, x7B, x7C, x7D, x7E) respectively. - RFC
		 * 3696 - 3 & errata, RFC 2822 - 3.2.4
		 * 
		 * Dots may also be present in the local part, but can not be the first
		 * nor last character, nor adjacent to another dot (.) (x2E). - RFC 3696
		 * - 3, RFC 2822 - 3.2.4
		 * 
		 * The local part may be a double quoted (") (x22) string consisting of
		 * any ASCII characters except the following: NULL (x00), TAB (x09), LF
		 * (x0A), CR (x0D), " (x22), \ (x5C). However the following are
		 * permitted in a local part double quoted string if escaped (preceded
		 * by a backslash, (\), (x5C)): x01 thru x09, x0B, x0C, x0E thru x7F. -
		 * RFC 3696 - 3 & errata, RFC 2822 - 3.2.1 - 3.2.5
		 * 
		 * + Maximum length of the local part is 64 characters. - RFC 3696 - 3 &
		 * errata, RFC 2821 - 4.5.3.1
		 * 
		 * Domain Part:
		 * 
		 * Domain part consists of dot separated labels of 1 to 63 characters
		 * each, up to a maximum total length of 255 characters (including dot
		 * delimiters). - RFC 3696 - 2, RFC 1035 2.3.1, RFC 2821 - 4.5.3.1, RFC
		 * 2181 - 11
		 * 
		 * Domain labels must begin and end with an alpha (a-z) (x61-x7A) (A-Z)
		 * (x41-x5A) or numeric (0-9) (x30-x39) character and may include
		 * hyphens (-) (x2D). In addition, the TLD (last label) must contain at
		 * least one alpha character or hyphen (not all numeric), and be at
		 * least two characters. - RFC 3696 - 2, RFC 1035 2.3.1, RFC 1123 - 2.1
		 * 
		 * Domain must be fully qualified (FQDN) and resolvable to an A or MX
		 * domain name system record. - RFC 2821 - 3.6
		 * 
		 * Domain may be an IP v4, IP v6 or IP v6/v4 address literal. - RFC 3696
		 * - 3, RFC 2821 - 4.1.3, RFC 2373 - 2.2
		 */
	}

	/**
	 * Data una stringa, contenente indirizzi email separati da ':' e/o ';',
	 * questo metodo verifica che tutti gli indirizzi email conenuti siano validi.
	 * 
	 * @param value stringa da verificare.
	 * @return <code>true</code> se la condizione è verificata, altrimenti <code>false</code>.
	 */
	public static boolean isValidMultipleEmailAddress(String value) {
		if (value == null)
			return false;
	
		// Crea l'array con le singole email
		String[] emailsArray = StringUtils.splitMultipleEmailAddressString(value);
	
		for (String singleEmail : emailsArray) {
			if (!isValidSingleEmailAddress(singleEmail))
				return false;
		}
	
		return true;
	}

	/**
	 * Metodo che crea un array di stringhe (indirizzi email) a partire da una stringa
	 * composta da più indirizzi email, separati da ':' e/o ';'.</br>
	 * 
	 * @param value stringa da dividere.
	 * @return <code>null</code> se la stringa passata è <code>null</code>, altrimenti un array di stringhe contenenti indirizzi email. 
	 */
	public static String[] splitMultipleEmailAddressString(String value) {
		if (value == null)
			return null;
	
		return value.replace(':', ';').split(";");
	}

	/**
	 * Metodo che individua la validità di una stringa come codice fiscale o
	 * partita iva. Accetta solo stringhe di lunghezza 11 o 16, inoltre i soli
	 * valori accettati per ogni carattere sono le lettere maiuscole da A a Z ed
	 * i numeri da 0 a 9. Tuttavia non verifica i valori dei caratteri in base
	 * alla loro posizione, ad esempio un codice fiscale contenente numeri nella
	 * prima sestina (di norma riservata solo a caratteri alfabetici per
	 * identificare cognome e nome) è ritenuto valido.
	 * 
	 * @param value
	 *            stringa da verificare.
	 * @return ritorna true se la stringa è valida, false altrimenti.
	 */
	public static boolean isValidCodiceFiscalePartitaIva(String value) {
		boolean valido = true;
	
		if (value == null)
			valido = false;
		else if (value.length() != 11 && value.length() != 16)
			valido = false;
		else {
			String campiValidi = "[A-Z0-9]{" + value.length() + "}";
			if (!value.matches(campiValidi))
				valido = false;
		}
		return valido;
	}
	
	/**
	 * Metodo che individua la validità di una stringa come codice fiscale per un'azienda. 
	 * Accetta solo stringhe di lunghezza 11 composte solo da caratteri numerici.
	 * 
	 * @param value stringa da verificare.
	 * @return ritorna <code>true</code> se la stringa è valida, <code>false</code> altrimenti.
	 */
	public static boolean isValidCodiceFiscaleAzienda(String value) {
		return validateRegularExpression(value,"[0-9]{11}");
	}
	
	/**
	 * Metodo che verifica se una stringa è valida secondo un'espressione regolare.
	 * Se la stringa passata in input è NULL il metodo restituisce "false". 
	 * @param value stringa da valutare
	 * @param regularExpression stringa contenente l'espressione regolare
	 * @return risultato del controllo
	 */
	public static boolean validateRegularExpression(String value, String regularExpression) {
		if (value == null)
			return false;
		return value.matches(regularExpression);
	}

	/**
	 * Metodo di pulizia dei campi, cancella gli zeri iniziali ove la stringa
	 * sia composta ESCLUSIVAMENTE di caratteri numerici.</br>
	 * Se la stringa numerica dovesse essere composta solo di uno o più '0', verrà restituito '0'.
	 * 
	 * @param value stringa da pulire.
	 * @return
	 */
	public static String dropInitialZerosIfNumber(String value) {
		if (value==null || value.isEmpty())
			return null;
		
		if (value.matches(REGEXP_INTEGER))
			value = value.replaceFirst("^0+", "");
		
		if (value.trim()==null || value.trim().isEmpty())
			value = "0";
		
		return value;
	}

	/**
	 * Converte un dato boolean in stringa.
	 * 
	 * @param value booleano da convertire.
	 * @return "SI" se il valore passato è <code>true</code>, altrimenti "NO".
	 */
	public static String formatBoolean(Boolean value) {
		String result = "";
		if (new Boolean(true).equals(value))
			result = "SI";
		else if (new Boolean(false).equals(value))
			result = "NO";
	
		return result;
	}

	/**
	 * Converte un carattere S/N nella sua forma completa Si/No.
	 * 
	 * @param sn carattere da convertire.
	 * @return "Si" se la stringa passata in input è "S", altrimenti "No".
	 */
	public static String convertSNtoSiNo(Character sn) {
		if (sn == null) {
			return "";
		}
		if (sn.toString().toLowerCase().equals("s")) {
			return "Si";
		} else if (sn.toString().toLowerCase().equals("n")) {
			return "No";
		}
	
		return "";
	}

	/**
	 * Converte una stringa in Boolean.
	 * 
	 * @param value stringa da convertire in Boolean.
	 * @return <code>true</code> se la stringa contiene un valore positivo, altrimenti <code>false</code>.
	 * @throws ClassCastException qualora la stringa passata in input non sia riconosciuta
	 * 			come valore possibile per la conversione in booleano.
	 */
	public static Boolean parseBoolean(String value) throws ParseException {
		if ("si".equalsIgnoreCase(value) || "s".equalsIgnoreCase(value)
				|| "yes".equalsIgnoreCase(value) || "y".equalsIgnoreCase(value)
				|| "true".equalsIgnoreCase(value)
				|| "vero".equalsIgnoreCase(value)
				|| "1".equals(value))
			return true;
		else if ("no".equalsIgnoreCase(value) || "n".equalsIgnoreCase(value)
				|| "false".equalsIgnoreCase(value)
				|| "falso".equalsIgnoreCase(value)
				|| "0".equals(value))
			return false;
		else
			throw new ParseException("Errore di parsing durante la conversione in Boolean del valore:'"+value+"'.", 0);
	}

	/**
	 * Verifica se la stringa passata sia <code>null</code> o vuota.</br>
	 * N.B. Non viene effettuato il trim sul valore.
	 *
	 * @param valore la stringa da controllare.
	 * @return <code>true</code> se la condizione è verificata, altrimenti <code>false</code>.
	 */
	public static boolean isNullOrEmpty(String valore) {
		boolean esito = false;
	
		if (valore == null || valore.isEmpty())
			esito = true;
	
		return esito;
	}

	public static String getStackTrace(Throwable aThrowable) {
		StringWriter result = null;
		PrintWriter printWriter = null;
		try {
			result = new StringWriter();
			printWriter = new PrintWriter(result);
			aThrowable.printStackTrace(printWriter);
		} finally { //CAST_202 + CAST_203 (CAST_COMMONS)
			if (printWriter != null) {
				printWriter.close();
			}
			if (result != null) {
				try {
					result.close();
				} catch (IOException e) {
					TraceLogger.traceError("Errore chiusura StringWriter.",
							Utils.class, e);
				}
			}
		}
		return result.toString();
	}
	
	/**
	 * Metodo che normalizza il nome di un comune italiano.
	 * @param cityName nome del comune
	 * @return stringa normalizzata
	 */
	public static String normalizeItalianCityName(String cityName) {
		if (cityName==null) return null;
		String result = cityName.trim();
		String[] tokens = result.split(" \\(");
//		result = org.apache.commons.lang.WordUtils.capitalizeFully(tokens[0]);
		result = result.replace(" A ", " a ");
		result = result.replace(" Di ", " di ");
		result = result.replace(" Dei ", " dei ");
		result = result.replace(" Del ", " del ");
		result = result.replace(" Dell'", " dell'");
		result = result.replace(" Della ", " della ");
		result = result.replace(" Da ", " da ");
		result = result.replace(" In ", " in ");
		result = result.replace(" Nel ", " nel ");
		result = result.replace(" Sul ", " sul ");
		result = result.replace(" Sulla ", " sulla ");
		if (tokens.length>1)
			result += " ("+tokens[1].toUpperCase();
		return result;
	}
	
	/**
	 * Metodo che restituisce il nome di un comune italiano in caratteri maiuscoli e sostituisce i caratteri accentati con gli apostrofi.
	 * @param cityName nome del comune
	 * @return stringa elaborata
	 */
	public static String upperCaseItalianCityName(String cityName) {
		if (cityName==null) 
			return null;
		String result = cityName.trim();	
		result = convertAccentToApostrophe(result);
		result = result.toUpperCase();
		return result;
	}
	
	
	/********************
	 * METODI DEPRECATI *
	 ********************/
	
	/**
	 * Metodo che converte una stringa composta da uno o più indirizzi email (validi o meno) separati da ':' e/o ';' in un array contenenti le singole stringhe email. 
	 * Se la stringa è null ritorna null. 
	 * @param value stringa da convertire.
	 * @return array di stringhe email (null se la stringa non contiene indirizzi validi)
	 * @deprecated utilizzare invece il metodo {@link #splitMultipleEmailAddressString(String value)}
	 */
	@Deprecated
	public static String[] emailAddressStringToEmailAddressArray(String value) {
		return splitMultipleEmailAddressString(value);
	}
	
	/**
	 * Converte una stringa in Boolean.
	 * 
	 * @param input stringa da convertire in booleano.
	 * @return <code>true</code> se la stringa contiene un valore positivo, altrimenti <code>false</code>.
	 * @throws ClassCastException qualora la stringa passata in input non sia riconosciuta
	 * 			come valore possibile per la conversione in booleano.
	 * @deprecated utilizzare invece il metodo {@link #parseBoolean(String value)}
	 */
	@Deprecated
	public static Boolean convertiStringInBoolean(String value) throws ClassCastException {
		try {
			return parseBoolean(value);
		} catch (ParseException e) {
			ClassCastException ne = new ClassCastException();
			ne.initCause(e);
			throw ne;
		}
	}
	
}
