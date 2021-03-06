package com.vince.boot.demo.webapp.be.utility;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionUtils {
	
	/**
	 * Ricava da un Throwable una string contenente lo stacktrace dell'eccezione.
	* @param throwable  il <code>Throwable</code> da esaminare
	* @return lo stacktrace generato dell'eccezione
	*/
	public static String getStackTrace(final Throwable throwable) {
		final StringWriter sw = new StringWriter();
		final PrintWriter pw = new PrintWriter(sw, true);
		throwable.printStackTrace(pw);
		return sw.getBuffer().toString();
	}
	
}
