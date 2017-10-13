package com.vince.boot.demo.webapp.be.utility;

import java.io.Serializable;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class TraceLogger implements Serializable {

	private static final long serialVersionUID = 1L;

	/* Modificando questi valori static è possibile riconfigurare il mappaggio tra
	 * i valori numerici del log ed i corrispondenti valori JavaLog e log4j. */
	private static final int FATAL = 1;  //Log4J only
	private static final int ERROR = 1;  //Log4J only
    private static final int SEVERE = 1; //JavaLog only
    private static final int WARN = 2;  //Log4J only
    private static final int WARNING = 2; //JavaLog only
    private static final int INFO = 3; //both Javalog & Log4J
    private static final int CONFIG = 5; //JavaLog only (originally 4, shifted to 5 for compatibility)
    private static final int FINE = 5; //JavaLog only
    private static final int DEBUG = 5; //Log4J only
    private static final int FINER = 7; //JavaLog only (originally 6, shifted to 7 for compatibility)
    private static final int FINEST = 7; //JavaLog only
    private static final int TRACE = 7; //Log4J only

    private static Logger logger = Logger.getLogger(TraceLogger.class);

    private static void init() {
		//commentato in quanto sostituito con la configurazione log di Spring
		//URL url = Loader.getResource("springconfig/spring.log4j.xml");
		//DOMConfigurator.configure(url);
    }

    public static void traceLog(java.util.logging.Level level, String messaggio) {
    	traceLog(getLoggingValue(level), messaggio, TraceLogger.class);
    }

    public static void traceLog(org.apache.log4j.Level level, String messaggio) {
    	traceLog(getLoggingValue(level), messaggio, TraceLogger.class);
    }

    public static void traceLog(int livello, String messaggio) {
    	traceLog(livello, messaggio, TraceLogger.class);
    }

    public static void traceLog(int livello, String messaggio, Class classe) {
        init();
        logger = Logger.getLogger(classe);
        logger.log(getLevelLog4j(livello), messaggio);
    }

  //INTEGRAZIONE ANEC-PATRIMONIO: metodo aggiunto x gridlink
	public static void traceLog(java.util.logging.Level level, String messaggio, Class classe) {
    	traceLog(getLoggingValue(level), messaggio, classe);
    }

    public static void traceLog(String messaggio, Class classe) {
    	traceLog(INFO, messaggio, classe);
    }

    public static void traceError(String messaggio, Class classe,Throwable th) {
        init();
        logger = Logger.getLogger(classe);
        logger.error(messaggio, th);
    }

    private static Level getLevelLog4j(int loggingValue) {
    	org.apache.log4j.Level loggingLevel = null;
        if (loggingValue==FATAL) { loggingLevel = org.apache.log4j.Level.FATAL; }
        else if (loggingValue==ERROR) { loggingLevel = org.apache.log4j.Level.ERROR; }
        else if (loggingValue==WARN) { loggingLevel = org.apache.log4j.Level.WARN; }
        else if (loggingValue==INFO) { loggingLevel = org.apache.log4j.Level.INFO; }
        else if (loggingValue==DEBUG) { loggingLevel = org.apache.log4j.Level.DEBUG; }
        else if (loggingValue==TRACE) { loggingLevel = org.apache.log4j.Level.TRACE; }
        return loggingLevel;
    }

    /**
     * Metodo che converte il valore numerico del livello di log nel corrispondente
     * oggetto java.util.logging.Level.
     * @param loggingValue valore numerico.
     * @return oggetto level di java log.
     */
	public static java.util.logging.Level getLevelJavaLog(int loggingValue) {
    	java.util.logging.Level loggingLevel = null;
        if (loggingValue==1) { loggingLevel = java.util.logging.Level.SEVERE; }
        else if (loggingValue==2) { loggingLevel = java.util.logging.Level.WARNING; }
        else if (loggingValue==3) { loggingLevel = java.util.logging.Level.INFO; }
        else if (loggingValue==4) { loggingLevel = java.util.logging.Level.CONFIG; }
        else if (loggingValue==5) { loggingLevel = java.util.logging.Level.FINE; }
        else if (loggingValue==6) { loggingLevel = java.util.logging.Level.FINER; }
        else if (loggingValue==7) { loggingLevel = java.util.logging.Level.FINEST; }
        return loggingLevel;
    }

    /** Metodo che converte da Level del logger java a valore int corrispondente.
     * Nella conversione viene fatto un declassamento dei valori per renderli compatibili
     * con quelli del log4J.
     * @param loggingLevel oggetto Level da convertire.
     * @return valore int corrispondente.
     */
    public static int getLoggingValue(java.util.logging.Level loggingLevel) {
    	int loggingValue = 3;
        if (java.util.logging.Level.SEVERE.equals(loggingLevel)) { loggingValue = SEVERE; } //CAST_199 + CAST_201 (CAST_COMMONS) modificati tutti gli == del metodo
        else if (java.util.logging.Level.WARNING.equals(loggingLevel)) { loggingValue = WARNING; }
        else if (java.util.logging.Level.INFO.equals(loggingLevel)) { loggingValue = INFO; }
        else if (java.util.logging.Level.CONFIG.equals(loggingLevel)) { loggingValue = CONFIG; }
        else if (java.util.logging.Level.FINE.equals(loggingLevel)) { loggingValue = FINE; }
        else if (java.util.logging.Level.FINER.equals(loggingLevel)) { loggingValue = FINER; }
        else if (java.util.logging.Level.FINEST.equals(loggingLevel)) { loggingValue = FINEST; }
        return loggingValue;
    }

    /** Metodo che converte da Level del logger java a valore int corrispondente.
     * @param loggingLevel oggetto Level da convertire.
     * @return valore int corrispondente.
     */
    public static int getLoggingValue(org.apache.log4j.Level loggingLevel) { //CAST_198 + CAST_200 (CAST_COMMONS)
    	int loggingValue = 3;
        if (org.apache.log4j.Level.ERROR.equals(loggingLevel)) { loggingValue = ERROR; }
        else if (org.apache.log4j.Level.WARN.equals(loggingLevel)) { loggingValue = WARN; }
        else if (org.apache.log4j.Level.INFO.equals(loggingLevel)) { loggingValue = INFO; }
        else if (org.apache.log4j.Level.DEBUG.equals(loggingLevel)) { loggingValue = DEBUG; }
        else if (org.apache.log4j.Level.TRACE.equals(loggingLevel)) { loggingValue = TRACE; }
        return loggingValue;
    }

	public static int getDEBUG() {
		return DEBUG;
	}

	public static int getINFO() {
		return INFO;
	}

	public static int getWARNING() {
		return WARNING;
	}

	public static int getWARN() {
		return WARN;
	}

	public static int getERROR() {
		return ERROR;
	}

	public static int getSEVERE() {
		return SEVERE;
	}

	public static int getCONFIG() {
		return CONFIG;
	}

	public static int getFINE() {
		return FINE;
	}

	public static int getFINER() {
		return FINER;
	}

	public static int getFINEST() {
		return FINEST;
	}

	public static int getTRACE() {
		return TRACE;
	}

}
