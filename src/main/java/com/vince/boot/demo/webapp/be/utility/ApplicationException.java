package com.vince.boot.demo.webapp.be.utility;

public class ApplicationException extends Exception {
	private static final long serialVersionUID = -5644960139675459949L;
	private static final String AUTH = "AUTH_";

	private int level;
	private String msgCode;
	private String msgField;
	private String msgText;

	public ApplicationException(Throwable e) {
		super(e);
	}
	
	public ApplicationException(String exceptionMessage) {
		super(exceptionMessage);
	}
	
	public ApplicationException(String exceptionMessage, Throwable initCauseException) {
		super(exceptionMessage, initCauseException);
	}
	
	public ApplicationException() {
		super("Errore applicativo");
	}

	/**
	 * @param code il codice del messaggio.
	 * @param field il campo del messaggio.
	 */
	public ApplicationException(String code, String field) {
		super(code + ": " + field);
		setMsgCode(code);
		setMsgField(field);
	}

	/**
	 * @param code il codice del messaggio.
	 * @param field il campo del messaggio.
	 * @param text il testo del messaggio.
	 * @param level il livello del messaggio.
	 */
	public ApplicationException(String code, String field, String text, int level) {
		super(code + ": " + text);
		setMsgCode(code);
		setMsgField(field);
		setMsgText(text);
		setLevel(level);
	}

	/**
	 * Resituisce il livello del messaggio.
	 * 
	 * @return il livello del messaggio.
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Restituisce il codice del messaggio.
	 * 
	 * @return il codice del messaggio.
	 */
	public String getMsgCode() {
		return msgCode;
	}

	/**
	 * Restituisce il campo del messaggio.
	 * 
	 * @return il campo del messaggio.
	 */
	public String getMsgField() {
		return msgField;
	}

	/**
	 * Restituisce il testo del messaggio.
	 * 
	 * @return il testo del messaggio.
	 */
	public String getMsgText() {
		return msgText;
	}

	/**
	 * Setta il livello del messaggio.
	 * 
	 * @param i il livello del messaggio.
	 */
	public void setLevel(int i) {
		level = i;
	}

	/**
	 * Setta il codice del messaggio.
	 * 
	 * @param string il codice del messaggio.
	 */
	public void setMsgCode(String string) {
		msgCode = string;
	}

	/**
	 * Setta il campo messaggio.
	 * 
	 * @param string campo messaggio.
	 */
	public void setMsgField(String string) {
		msgField = string;
	}

	/**
	 * Setta il testo del messaggio.
	 * 
	 * @param string testo del messaggio.
	 */
	public void setMsgText(String string) {
		msgText = string;
	}

	public static String getAuth() {
		return AUTH;
	}
}