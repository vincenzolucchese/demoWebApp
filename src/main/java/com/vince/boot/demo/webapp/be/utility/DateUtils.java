package com.vince.boot.demo.webapp.be.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class DateUtils {
	public static final String DATE_FORMAT_DEFAULT = "dd/MM/yyyy";
	public static final String DATETIME_FORMAT_DEFAULT = "dd/MM/yyyy HH:mm:ss";
	public static final String TIMESTAMP_FORMAT_DEFAULT = "dd/MM/yyyy HH:mm:ss.SSS";
	public static final String DATE_FORMAT_ISO = "yyyy-MM-dd";
	public static final String DATETIME_FORMAT_ISO = "yyyy-MM-ddTHH:mm:ss";
	private static final Date infiniteFutureDate = getDate(9999,12,31);
	private static final Date infinitePastDate = getDate(1000,1,1);
	
	/********************
	 * METODI DEPRECATI *
	 ********************/
	
	/**
	 * Controlla se la data passata e' nel formato "dd/MM/yyyy"
	 * @param s
	 * @return
	 * @deprecated utilizzare invece il metodo {@link #isValidDate(String data)}
	 */
	@Deprecated
	public static boolean isDataValidaDdMmYyyy(String data) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	        format.parse(data);
	    } catch (ParseException e) {
	        return false;
	    }
		return true;
	}
	
	/**
	 * Da un oggetto Date estre l' anno e lo restituisce come long
	 * @param date
	 * @return
	 * @deprecated utilizzare invece il metodo {@link #extractYearFromDate(Date date)}
	 */
	@Deprecated
	public static Integer convertYearDateInInteger(Date date){
		return extractYearFromDate(date);
	}
	
	/**
	 * Restituisce una oggetto Date impostato al primo gennaio dell'anno passato in input
	 * @param anno
	 * @return
	 * @deprecated utilizzare invece il metodo {@link #getFirstDayOfYear(String anno)}
	 */
	@Deprecated
	public static Date getAnnoFiscaleDate(String anno){
		return getFirstDayOfYear(anno);
	}
	
	/**
	 * Restituisce una oggetto Date impostato al primo gennaio dell'anno passato in input
	 * @param anno
	 * @return
	 * @deprecated utilizzare invece il metodo {@link #getFirstDayOfYear(int anno)}
	 */
	@Deprecated
	public static Date getAnnoFiscaleDate(int anno){
		return getFirstDayOfYear(anno);
	}
	
	/**
	 * Restituisce una oggetto Date impostato al primo gennaio dell'anno passato in input
	 * @param anno
	 * @return
	 * @deprecated utilizzare invece il metodo {@link #getFirstDayOfYear(String anno)}
	 */
	@Deprecated
	public static Date getAnnoRiferimentoDate(String anno){
		return getFirstDayOfYear(Integer.parseInt(anno));
	}
	
	/**
	 * Metodo di utilità che restituisce un oggetto Long pari all'anno precedente all'anno di riferimento.
	 * @return oggetto Long contenente l'anno fiscale precedente.
	 * @deprecated utilizzare invece il metodo {@link #getAnnoRiferimento()}
	 */
	@Deprecated
	public static Long getAnnoFiscalePrecedente(){
		return getAnnoRiferimento();
	}
	
	/**
	 * Restituisce una oggetto Date impostato al primo gennaio dell'anno di riferimento.
	 * @return
	 * @deprecated utilizzare invece il metodo {@link #getAnnoRiferimentoDate()}
	 */
	@Deprecated
	public static Date getAnnoFiscalePrecedenteDate(){
		return getAnnoRiferimentoDate();
	}
	
	/**
	 * Restituisce un oggetto Date impostato con i valori della data attuale.
	 * 
	 * @return Date la data attuale nell'oggetto Date
	 * @deprecated utilizzare invece il metodo {@link #getCurrentTime()}
	 */
	@Deprecated
	public static Date getDataAttuale() {
		Calendar calendario = new GregorianCalendar();
		return calendario.getTime();
	}

	/**
	 * Restituisce un oggetto Date impostato con i valori della data attuale con o meno 
	 * il time impostato.
	 * @param resetTime indica se resettare o meno la parte time.
	 * @return Date la data attuale nell'oggetto Date
	 * @deprecated utilizzare invece il metodo {@link #getCurrentDate() o #getCurrentTime()}
	 */
	@Deprecated
	public static Date getDataAttuale(boolean resetTime)
	{		
		Calendar calendario = new GregorianCalendar();
		
		if(resetTime){
			calendario.set(Calendar.HOUR_OF_DAY, 0);
			calendario.set(Calendar.MINUTE, 0);
			calendario.set(Calendar.SECOND, 0);
			calendario.set(Calendar.MILLISECOND, 0);
		}
		
		return calendario.getTime();
	}
	
	/**
	 * Restituisce un oggetto Date impostato con i valori della data attuale (inclusiva della parte time)
	 * aggiungendo il numero di giorni passati in input.
	 * 
	 * @param delta
	 *            Numero di giorni da aggiungere alla data odierna
	 * @return Date la data attuale nell'oggetto Date
	 * @deprecated utilizzare invece il metodo {@link #getCurrentTimePlusDays()}
	 */
	@Deprecated
	public static Date getDataAttualePiuDelta(int delta) {
		return getCurrentTimePlusDays(delta);
	}
	
	/**
	 * Converte una data in stringa utilizzando il formato di default.
	 * 
	 * @param date la data da convertire.
	 * @return la data in formato stringa.
	 * @deprecated utilizzare invece il metodo {@link DateUtils#formatDate(String data)}
	 */
	@Deprecated
	public static String dateFormat(Date date) {
		return DateUtils.formatDate(date);
	}
	
	/**
	 * Converte una data in stringa utilizzando il formato specificato.
	 * 
	 * @param date la data da convertire.
	 * @param format formato di conversione.
	 * @return la data in formato stringa.
	 * @deprecated utilizzare invece il metodo {@link DateUtils#formatDate(String data)}
	 */
	@Deprecated
	public static String dateFormat(Date date, String format) {
		return DateUtils.formatDate(date, format);
	}
	
	/**
	 * Aggiunge ad una data un certo numero di giorni/ore/minuti/etc.
	 * Il tipo di valore da incrementare viene passato come parametro.
	 *
	 * @param date  la data da incrementare
	 * @param calendarField  il tipo di valore da incrementare
	 * @param amount il numero di cui incrementare il valore (accetta anche negativi)
	 * @return la nuova data incrementata
	 * @throws IllegalArgumentException se la data è null
	 */
	private static Date add(Date date, int calendarField, int amount) {
		if (date == null) { throw new IllegalArgumentException("La data passata in input non può essere null."); }
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(calendarField, amount);
		return c.getTime();
	}

	/**
	 * Aggiunge ad una data un certo numero di anni.
	 *
	 * @param date  la data da incrementare
	 * @param amount il numero di cui incrementare il valore (accetta anche negativi)
	 * @return la nuova data incrementata
	 * @throws IllegalArgumentException se la data è null
	 */
	public static Date addYears(Date date, int amount) {		
		return add(date, Calendar.YEAR, amount);
	}
	
	/**
	 * Aggiunge ad una data un certo numero di mesi.
	 *
	 * @param date  la data da incrementare
	 * @param amount il numero di cui incrementare il valore (accetta anche negativi)
	 * @return la nuova data incrementata
	 * @throws IllegalArgumentException se la data è null
	 */
	public static Date addMonths(Date date, int amount) {		
		return add(date, Calendar.MONTH, amount);
	}
	
	/**
	 * Aggiunge ad una data un certo numero di settimane.
	 *
	 * @param date  la data da incrementare
	 * @param amount il numero di cui incrementare il valore (accetta anche negativi)
	 * @return la nuova data incrementata
	 * @throws IllegalArgumentException se la data è null
	 */
	public static Date addWeeks(Date date, int amount) {		
		return add(date, Calendar.WEEK_OF_YEAR, amount);
	}
	
	/**
	 * Aggiunge ad una data un certo numero di giorni.
	 *
	 * @param date  la data da incrementare
	 * @param amount il numero di cui incrementare il valore (accetta anche negativi)
	 * @return la nuova data incrementata
	 * @throws IllegalArgumentException se la data è null
	 */
	public static Date addDays(Date date, int amount) {		
		return add(date, Calendar.DAY_OF_MONTH, amount);
	}
	
	/**
	 * Aggiunge ad una data un certo numero di ore.
	 *
	 * @param date  la data da incrementare
	 * @param amount il numero di cui incrementare il valore (accetta anche negativi)
	 * @return la nuova data incrementata
	 * @throws IllegalArgumentException se la data è null
	 */
	public static Date addHours(Date date, int amount) {		
		return add(date, Calendar.HOUR_OF_DAY, amount);
	}
	
	/**
	 * Aggiunge ad una data un certo numero di minuti.
	 *
	 * @param date  la data da incrementare
	 * @param amount il numero di cui incrementare il valore (accetta anche negativi)
	 * @return la nuova data incrementata
	 * @throws IllegalArgumentException se la data è null
	 */
	public static Date addMinutes(Date date, int amount) {		
		return add(date, Calendar.MINUTE, amount);
	}
	
	/**
	 * Aggiunge ad una data un certo numero di secondi.
	 *
	 * @param date  la data da incrementare
	 * @param amount il numero di cui incrementare il valore (accetta anche negativi)
	 * @return la nuova data incrementata
	 * @throws IllegalArgumentException se la data è null
	 */
	public static Date addSeconds(Date date, int amount) {		
		return add(date, Calendar.SECOND, amount);
	}
	
	/**
	 * Aggiunge ad una data un certo numero di millisecondi.
	 *
	 * @param date  la data da incrementare
	 * @param amount il numero di cui incrementare il valore (accetta anche negativi)
	 * @return la nuova data incrementata
	 * @throws IllegalArgumentException se la data è null
	 */
	public static Date addMilliseconds(Date date, int amount) {		
		return add(date, Calendar.MILLISECOND, amount);
	}
	
	/***************************************
	 * METODI BASATI SU LOGICA APPLICATIVA *
	 ***************************************/
	
	/**
	 * Metodo che restituisce il valore del parametro "custom.anno.riferimento" sottoforma di oggetto Long.
	 * @return Long contenente l'anno di riferimento.
	 */
	public static Long getAnnoRiferimento() {
		Long annoRiferimento;
		//legge il valore dalle properties
//		String strAnnoRiferimento = SpringBeanFactory.getProprietaSistemaService().get("custom.anno.riferimento");
		String strAnnoRiferimento = "";
		try {
			annoRiferimento = Long.valueOf(strAnnoRiferimento);
		} catch (NumberFormatException e) {
			annoRiferimento = null;
		}
		return annoRiferimento;
	}
	
	/**
	 * Metodo che restituisce un oggetto Date impostato al primo gennaio dell'anno di riferimento dei dati (calcolato dal parametro "custom.anno.riferimento").
	 * @return Date contenente il primo gennaio dell'anno di riferimento.
	 */
	public static Date getAnnoRiferimentoDate() {
		Long anno = getAnnoRiferimento();
		return getFirstDayOfYear(anno.intValue());
	}
	
	/**
	 * Metodo che restituisce un oggetto Date impostato al primo gennaio dell'anno di riferimento dei dati (calcolato dal parametro "custom.anno.riferimento").
	 * @return Date contenente il primo gennaio dell'anno di riferimento.
	 */
	public static Date getAnnoRiferimentoLastDayDate() {
		Long anno = getAnnoRiferimento();
		return getLastDayOfYear(anno.intValue());
	}
	
	/**
	 * Metodo di utilità che restituisce l'anno fiscale corrente (equivale all'anno successivo a quello di riferimento).
	 * 
	 * @return oggetto Long contenente l'anno fiscale corrente.
	 */
	public static Long getAnnoFiscaleCorrente() {
		return getAnnoRiferimento() + 1;
	}
	
	/**
	 * Restituisce un oggetto Date impostato al primo gennaio dell'anno fiscale corrente (equivale all'anno successivo a quello di riferimento).
	 * @return
	 */
	public static Date getAnnoFiscaleCorrenteDate(){
		return getFirstDayOfYear(getAnnoFiscaleCorrente().intValue());
	}
	
	/**
	 * Restituisce un oggetto Long contenente l'anno precedente all'anno di riferimento.
	 * NOTA: questo metodo NON controlla che esistano effettivamente dei dati di storico per l'anno restituito.
	 * @return
	 */
	public static Long getUltimoAnnoStorico() {
		return getAnnoRiferimento() - 1;
	}
	
	/**
	 * Restituisce un oggetto Date impostato al primo gennaio dell'anno precedente all'anno di riferimento.
	 * NOTA: questo metodo NON controlla che esistano effettivamente dei dati di storico per l'anno restituito.
	 * @return
	 */
	public static Date getUltimoAnnoStoricoDate() {
		return getFirstDayOfYear(getUltimoAnnoStorico().intValue());
	}
	
	/***************************
	 * METODI DI FORMATTAZIONE *
	 ***************************/
	
	/**
	 * Converte una data in stringa utilizzando il formato di default.
	 * 
	 * @param date la data da convertire.
	 * @return la data in formato stringa.
	 */
	public static String formatDate(Date date) {
		return formatDate(date, null);
	}

	/**
	 * Converte una data in stringa utilizzando il formato ISO.
	 * 
	 * @param date la data da convertire.
	 * @return la data in formato stringa.
	 */
	public static String formatDateIso(Date date) {
		return formatDate(date, DateUtils.DATE_FORMAT_ISO);
	}
	
	/**
	 * Converte una data in stringa utilizzando il formato specificato.
	 * 
	 * @param date la data da convertire.
	 * @param format formato di conversione.
	 * @return la data in formato stringa.
	 */
	public static String formatDate(Date date, String format) {
		if (date == null) return null;
		
		String dateFormat;
		if (format==null || format.equals(""))
			dateFormat = DATE_FORMAT_DEFAULT;
		else
			dateFormat = format;

		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(date);
	}
	
	/**
	 * Converte una data (contenente anche la parte time) in stringa utilizzando il formato di default.
	 * 
	 * @param date la data da convertire.
	 * @return la data in formato stringa.
	 */
	public static String formatDateTime(Date date) {
		return formatDateTime(date, null);
	}

	/**
	 * Converte una data (contenente anche la parte time) in stringa utilizzando il formato specificato.
	 * 
	 * @param date la data da convertire.
	 * @param format formato di conversione.
	 * @return la data in formato stringa.
	 */
	public static String formatDateTime(Date date, String format) {
		if (date == null) return null;
		
		String dateFormat;
		if (format==null || format.equals(""))
			dateFormat = DATETIME_FORMAT_DEFAULT;
		else
			dateFormat = format;

		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(date);
	}
	
	/**
	 * Converte una data (contenente anche la parte time e millisecondi) in stringa utilizzando il formato di default.
	 * 
	 * @param date la data da convertire.
	 * @return la data in formato stringa.
	 */
	public static String formatTimeStamp(Date date) {
		return formatTimeStamp(date, null);
	}
	
	/**
	 * Converte una data (contenente anche la parte time e millisecondi) in stringa utilizzando il formato specificato.
	 * 
	 * @param date la data da convertire.
	 * @param format formato di conversione.
	 * @return la data in formato stringa.
	 */
	public static String formatTimeStamp(Date date, String format) {
		if (date == null) return null;
		
		String dateFormat;
		if (format==null || format.equals(""))
			dateFormat = TIMESTAMP_FORMAT_DEFAULT;
		else
			dateFormat = format;

		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(date);
	}
	
	/*********************
	 * METODI DI PARSING *
	 *********************/
	
	/**
	 * Converte una stringa in data utilizzando il formato di default. <br>
	 * Questo metodo effetta un parsing completo e NON accetta i valori formalmente validi ma non possibili come date (es.: 31/02/2000). </br>
	 * 
	 * @param source stringa da convertire.
	 * @return la data convertita.
	 */
	public static Date parseDate(String source) {
		return parseDate(source, null);
	}
	
	/**
	 * Converte una stringa in data utilizzando il formato specificato. <br>
	 * Questo metodo effetta un parsing completo e NON accetta i valori formalmente validi ma non possibili come date (es.: 31/02/2000). </br>
	 * 
	 * @param source stringa da convertire.
	 * @param format formato di conversione.
	 * @return la data convertita.
	 */
	public static  Date parseDate(String source, String format) {
		Date result = null;
		
		try {
			result = parseDateWithException(source, format);
		} catch (ParseException e) {
			TraceLogger.traceLog(TraceLogger.getDEBUG(), "Eccezione sul parse di: " + source +", con formato " + format + " ");
		}
		
		return result;
	}
	
	/**
	 * Converte una stringa in data utilizzando il formato specificato.
	 * 
	 * @param source stringa da convertire.
	 * @param format formato di conversione.
	 * @param boolean che indica se il parsing deve essere eeguito in modalità lenient (e quindi accetta anche date impossibili tipo 31/02/2000) o meno.
	 * @return la data convertita.
	 */
	public static  Date parseDate(String source, String format, boolean lenient) {
		Date result = null;
		
		try {
			result = parseDateWithException(source, format, lenient);
		} catch (ParseException e) {
			TraceLogger.traceLog(TraceLogger.getDEBUG(), "Eccezione sul parse di: " + source +", con formato " + format + " ");
		}
		
		return result;
	}
	
	/**
	 * Converte una stringa in data utilizzando il formato di default. </br> <br>
	 * Questo metodo effetta un parsing completo e NON accetta i valori formalmente validi ma non possibili come date (es.: 31/02/2000). </br>
	 * Il metodo può sollevare un eccezione di conversione.
	 * 
	 * @param source stringa da convertire.
	 * @return la data convertita.
	 * @throws ParseException
	 */
	public static Date parseDateWithException(String source) throws ParseException {
		return parseDateWithException(source,null);
	}
	
	/**
	 * Converte una stringa in data utilizzando il formato specificato. </br>
	 * Questo metodo non accetta i valori formalmente validi ma non possibili come date (es.: 31/02/2000). </br>
	 * Il metodo può sollevare un eccezione di conversione.
	 * 
	 * @param source stringa da convertire.
	 * @param format formato di conversione.
	 * @return la data convertita.
	 * @throws ParseException
	 */
	public static Date parseDateWithException(String source, String format) throws ParseException {
		return parseDateWithException(source, format, false);
	}
	
	/**
	 * Converte una stringa in data utilizzando il formato specificato. </br>
	 * Il metodo può sollevare un eccezione di conversione.
	 * 
	 * @param source stringa da convertire.
	 * @param format formato di conversione.
	 * @param boolean che indica se il parsing deve essere eeguito in modalità lenient (e quindi accetta anche date impossibili tipo 31/02/2000) o meno.
	 * @return la data convertita.
	 * @throws ParseException
	 */
	public static Date parseDateWithException(String source, String format, boolean lenient) throws ParseException {
		String dateFormat;
		if (format==null || format.equals("")) {
			dateFormat = DATE_FORMAT_DEFAULT;
		} else
			dateFormat = format;
		
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		sdf.setLenient(lenient);
		
		return sdf.parse(source);
	}
	
	/**
	 * Converte una stringa in data interpretando il formato di input. <br>
	 * Questo metodo effetta un parsing completo e NON accetta i valori formalmente validi ma non possibili come date (es.: 31/02/2000). </br>
	 * 
	 * @param source stringa da convertire.
	 * @return la data convertita. Se il valore non è valido o non è convertibile torna <code>null</code>.
	 */
	public static Date parseDateMultiFormat(String source) {
		Date data = null;
		if (isDefaultFormatDate(source))
			data = parseDate(source);
		else if (isISOFormatDate(source))
			data = parseDate(source, DATE_FORMAT_ISO);

		return data;
	}
	
	/*************************
	 * METODI DI VALIDAZIONE *
	 *************************/
	
	/**
	 * Controlla che la data fornita sia nel formato di default {@link #DATE_FORMAT_DEFAULT}.
	 * Questo metodo controlla solo la validità del formato e non se la data è una data possibile (es. accetta anche 31/02/2000).
	 * 
	 * @param data la data da verificare.
	 * @return <code>true</code> se la condizione è verificata, altrimenti <code>false</code>.
	 */
	public static boolean isDefaultFormatDate(String dateString) {
		boolean esito = true;
		try {
			parseDateWithException(dateString, DATE_FORMAT_DEFAULT, true);
		} catch (ParseException e) {
			esito = false;
		}
		return esito;
	}

	/**
	 * Controlla che la data fornita sia nel formato ISO {@link #DATE_FORMAT_ISO}.
	 * Questo metodo controlla solo la validità del formato e non se la data è una data possibile (es. accetta anche 31/02/2000).
	 *
	 * @param data la data da verificare.
	 * @return <code>true</code> se la condizione è verificata, altrimenti <code>false</code>.
	 */
	public static boolean isISOFormatDate(String dateString) {
		boolean esito = true;
		try {
			parseDateWithException(dateString, DATE_FORMAT_ISO, true);
		} catch (ParseException e) {
			esito = false;
		}
		return esito;
	}

	/**
	 * Controlla che la data fornita sia convertibile nel formato di default.</br>
	 * Un valore <code>null</code> viene considerato non valido.
	 *
	 * @param data la data da verificare.
	 *
	 * @return <code>true</code> se la condizione è verificata, altrimenti <code>false</code>.
	 */
	public static boolean isValidDate(String data) {
		return isValidDate(data, DATE_FORMAT_DEFAULT);
	}

	/**
	 * Controlla che la data fornita sia convertibile nel formato passato in input.</br> <br>
	 * Questo metodo effetta un parsing completo e NON accetta i valori formalmente validi ma non possibili come date (es.: 31/02/2000). </br>
	 * Un valore <code>null</code> viene considerato non valido.
	 *
	 * @param data la data da verificare.
	 * @param formato il formato di conversione.
	 *
	 * @return <code>true</code> se la condizione è verificata, altrimenti <code>false</code>.
	 */
	public static boolean isValidDate(String data, String formato) {
		boolean esito = true;

		if (data == null)
			esito = false;
		else
			esito = (parseDate(data, formato) != null);

		return esito;
	}

	/**************************
	 * METODI DI USO GENERICO *
	 **************************/
	
	/**
	 * Da un oggetto Date estre l' anno e lo restituisce come long
	 * @param date
	 * @return
	 */
	public static Integer extractYearFromDate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		Integer year = new Integer(c.get(Calendar.YEAR));
		return year;
	}
	
	/**
	 * Restituisce una oggetto Date impostato al primo gennaio dell'anno passato in input
	 * @param anno
	 * @return
	 */
	public static Date getFirstDayOfYear(int anno) {
		Calendar c = Calendar.getInstance();
		c.set(
				anno //anno
				,0
				,1
				,0
				,0
				,0
				);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}
	
	/**
	 * Restituisce un oggetto Date impostato al primo gennaio dell'anno passato in input
	 * @param anno
	 * @return
	 */
	public static Date getFirstDayOfYear(Date anno) {
		return getFirstDayOfYear(extractYearFromDate(anno));
	}
	
	/**
	 * Restituisce un oggetto Date impostato al primo gennaio dell'anno passato in input
	 * @param anno
	 * @return
	 */
	public static Date getFirstDayOfYear(String anno) {
		return getFirstDayOfYear(Integer.parseInt(anno));
	}
	
	/**
	 * Restituisce una oggetto Date impostato al 31 dicembre dell'anno passato in input
	 * @param anno
	 * @return
	 */
	public static Date getLastDayOfYear(int anno) {
		Calendar c = Calendar.getInstance();
		c.clear();
		c.set(
				anno //anno
				,11
				,31
				,0
				,0
				,0
				);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}
	
	/**
	 * Restituisce una oggetto Date impostato al 31 dicembre dell'anno contenuto nella date passata in input
	 * @param anno oggetto Date da cui estrapolare l'anno
	 * @return
	 */
	public static Date getLastDayOfYear(Date anno) {
		return getLastDayOfYear(extractYearFromDate(anno));
	}
	
	/**
	 * Restituisce una oggetto Date impostato al 31 dicembre dell'anno contenuto nella date passata in input
	 * @param anno oggetto Date da cui estrapolare l'anno
	 * @return
	 */
	public static Date getLastDayOfYear(String anno) {
		return getLastDayOfYear(Integer.parseInt(anno));
	}
	
	/**
	 * Restituisce un oggetto Date impostato con i parametri in input.
	 */
	public static Date getDate(int anno, int mese, int giorno) {
		Calendar c = Calendar.getInstance();
		c.clear();
		c.set(anno, mese-1, giorno);

		return c.getTime();
	}
	
	/**
	 * Metodo che dato un anno, calcola la data al 01/01.
	 * 
	 * @param anno anno dal quale ricavare la data.
	 * @return la data al 01/01.
	 */
	public static Date getDateFromAnno(int anno) {
		return new GregorianCalendar(anno, 0, 1).getTime();
	}
	
	/**
	 * Restituisce un oggetto Date impostato con i valori della data attuale.
	 * I valori della parte time dell'oggetto restituito sono impostati a 0.
	 * 
	 * @return Date la data attuale nell'oggetto Date
	 */
	public static Date getCurrentDate() {
		Calendar calendario = new GregorianCalendar();
		calendario.set(Calendar.HOUR_OF_DAY, 0);
		calendario.set(Calendar.MINUTE, 0);
		calendario.set(Calendar.SECOND, 0);
		calendario.set(Calendar.MILLISECOND, 0);
		return calendario.getTime();
	}

	/**
	 * Restituisce un oggetto Date impostato con i valori del timestamp attuale.
	 * @param resetTime indica se resettare o meno la parte time.
	 * @return Date la data attuale nell'oggetto Date
	 */
	public static Date getCurrentTime()
	{
		Calendar calendario = new GregorianCalendar();		
		return calendario.getTime();
	}
	
	/**
	 * Restituisce un oggetto Date impostato con i valori della data attuale (ma con la parte time impostata a 0)
	 * aggiungendo il numero di giorni passati in input.
	 * 
	 * @param days
	 *            Numero di giorni da aggiungere alla data odierna
	 * @return Date la data attuale nell'oggetto Date
	 */
	public static Date getCurrentDatePlusDays(int days) {
		return addDays(getCurrentDate(), days);
	}
	
	/**
	 * Restituisce un oggetto Date impostato con i valori della data attuale (inclusiva della parte time).
	 * aggiungendo il numero di giorni passati in input.
	 * 
	 * @param days
	 *            Numero di giorni da aggiungere alla data odierna
	 * @return Date la data attuale nell'oggetto Date
	 */
	public static Date getCurrentTimePlusDays(int days) {
		return addDays(getCurrentTime(), days);
	}

	/**
	 * Ritorna il valore espresso in mesi del periodo passato in input nella
	 * forma anni e mesi (separati).
	 * 
	 * Converte il parametro anni nel corrispondente valore in mesi e somma al
	 * risultato il parametro mesi
	 * 
	 * es: 2 anni e 3 mesi
	 * 
	 * 1) 2 * 12 = 24 2) 24 + 3 = 27
	 * 
	 * risultato = 27 (mesi).
	 * 
	 * @param anni
	 * @param mesi
	 * @return
	 */
	public static int convertiPeriodoAnniMesiInMesi(int anni, int mesi) {
		return anni * 12 + mesi;
	}
	
	/**
	 * Metodo che ritorna una data molto avanti nel tempo che corrisponde ad un valore simbolicamente infinito del futuro.  
	 * @return la data infinita nel futuro
	 */
	public static Date getInfiniteFutureDate() {
		return infiniteFutureDate;
	}
	
	/**
	 * Metodo che ritorna una data molto indietro nel tempo che corrisponde ad un valore simbolicamente infinito del passato.  
	 * @return la data infinita nel passato
	 */
	public static Date getInfinitePastDate() {
		return infinitePastDate;
	}
	
	/**
	 * Metodo che verifica se una data è compresa fra altre due date.
	 * Il confronto può essere eseguito in modalità inclusiva (i due estremi sono compresi nel range di validità) 
	 * o esclusiva (i due estremi non sono compresi nel range di validità).
	 * Le date che descrivono il range temporale non devono essere necessariamente passate in un ordine specifico 
	 * (es. limitDate1 può essere sia il limite inferiore sia quello superiore del range). 
	 * @param dateToCompare data di cui si vuole verificare l'inclusione nel range temporale.
	 * @param limitDate1 primo limite del range temporale.
	 * @param limitDate2 secondo limite del range temporale.
	 * @param inclusive booleano che indica se il confronto deve essere eseguito in modalità inclusiva o esclusiva.
	 * @return risultato della verifica (true = data inclusa nel range, false = data al di fuori del range). 
	 */
	public static boolean between(Date dateToCompare, Date limitDate1, Date limitDate2, boolean inclusive) {
		if (dateToCompare == null || limitDate1 == null || limitDate2 == null) 
		{ throw new IllegalArgumentException("Le date passate in input non possono essere null."); }
		
		Date lowerLimit = null;
		Date upperLimit = null;
		if (limitDate1.before(limitDate2)) {
			lowerLimit=limitDate1;
			upperLimit=limitDate2;
		}
		else {
			lowerLimit=limitDate2;
			upperLimit=limitDate1;
		}
		
		boolean result = false;
		if (inclusive) { //confronto inclusivo degli estremi
			result = lowerLimit.compareTo(dateToCompare)<=0 && upperLimit.compareTo(dateToCompare)>=0;
		}
		else { //confronto esclusivo degli estremi
			result = lowerLimit.compareTo(dateToCompare)<0 && upperLimit.compareTo(dateToCompare)>0;
		}
		
		return result;
	}
	
	/**
	 * Metodo che verifica se una data è compresa fra altre due date (le due date limite sono incluse nel range di validità).
	 * Le date che descrivono il range temporale non devono essere necessariamente passate in un ordine specifico 
	 * (es. limitDate1 può essere sia il limite inferiore sia quello superiore del range). 
	 * @param dateToCompare data di cui si vuole verificare l'inclusione nel range temporale.
	 * @param limitDate1 primo limite del range temporale.
	 * @param limitDate2 secondo limite del range temporale.
	 * @return risultato della verifica (true = data inclusa nel range, false = data al di fuori del range). 
	 */
	public static boolean inclusiveBetween(Date dateToCompare, Date limitDate1, Date limitDate2) {
		return between(dateToCompare, limitDate1, limitDate2, true);
	}
	
	/**
	 * Metodo che verifica se una data è compresa fra altre due date (le due date limite sono escluse dal range di validità).
	 * Le date che descrivono il range temporale non devono essere necessariamente passate in un ordine specifico 
	 * (es. limitDate1 può essere sia il limite inferiore sia quello superiore del range). 
	 * @param dateToCompare data di cui si vuole verificare l'inclusione nel range temporale.
	 * @param limitDate1 primo limite del range temporale.
	 * @param limitDate2 secondo limite del range temporale.
	 * @return risultato della verifica (true = data inclusa nel range, false = data al di fuori del range). 
	 */
	public static boolean exclusiveBetween(Date dateToCompare, Date limitDate1, Date limitDate2) {
		return between(dateToCompare, limitDate1, limitDate2, false);
	}
	
	/**
	 * Metodo che tronca la data eliminando la parte successiva al giorno (azzera la parte time).
	 * 
	 * @param date  la data da troncare
	 * @return l'oggetto Date troncato
	 * @throws IllegalArgumentException se la data è null
	 */
	public static Date truncateToDay(Date date) {
		if (date == null){ throw new IllegalArgumentException("La data passata in input non può essere null."); }
		Calendar calendario = new GregorianCalendar();
		calendario.setTime(date);
		calendario.set(Calendar.HOUR_OF_DAY, 0);
		calendario.set(Calendar.MINUTE, 0);
		calendario.set(Calendar.SECOND, 0);
		calendario.set(Calendar.MILLISECOND, 0);
		return calendario.getTime();
	}
	
	/**
	 * Metodo verifica se la parte time della data è a zero.
	 * 
	 * @param date  la data da verificare
	 * @return boolean (true se la parte time è a zero, false altrimenti)
	 * @throws IllegalArgumentException se la data è null
	 */
	public static boolean isDateWithoutTimePart(Date date) {
		if (date == null){ throw new IllegalArgumentException("La data passata in input non può essere null."); }
		Calendar calendario = new GregorianCalendar();
		calendario.setTime(date);
		return (
				calendario.get(Calendar.HOUR_OF_DAY) == 0 &&
				calendario.get(Calendar.MINUTE) == 0 &&
				calendario.get(Calendar.SECOND) == 0 &&
				calendario.get(Calendar.MILLISECOND)== 0 
		);
	}

	public static void main(String[] args) throws Exception {
		System.out.println(formatDateTime(new Date()));
		System.out.println(formatTimeStamp(new Date()));
	}
}
