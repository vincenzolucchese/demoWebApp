package com.vince.boot.demo.webapp.be.utility;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.Vector;


public class Utils {
	
	/**
	 * Metodo che restituisce il primo valore non null da una serie di argomenti
	 * di tipo variabile.
	 * 
	 * @param <T>
	 *            tipo di oggetto da restituire (identico a quello degli oggetti
	 *            passati come argomenti da confrontare)
	 * @param items
	 *            lista di valori tra cui identificare il primo non null.
	 * @return primo oggetto non null identificato (o null in caso non ce ne
	 *         siano).
	 */
	public static <T> T coalesce(T... items) {
		for (T i : items)
			if (i != null)
				return i;
		return null;
	}

	/**
	 * Metodo che restituisce il primo valore non null da una coppia di
	 * argomenti di tipo variabile. E' funzionalmente identico al metodo che
	 * accetta più valori ma lo sostituisce in caso di due soli argomenti per
	 * motivi puramente prestazionali.
	 * 
	 * @param <T>
	 *            tipo di oggetto da restituire (identico a quello degli oggetti
	 *            passati come argomenti da confrontare)
	 * @param a
	 *            primo oggetto da confrontare
	 * @param b
	 *            secondo oggetto da confrontare
	 * @return primo oggetto non null identificato (o null in caso non ce ne
	 *         siano).
	 */
	public static <T> T coalesce(T a, T b) {
		return a == null ? b : a;
	}

	/**
	 * Metodo che "true" se soltanto uno degli argomenti passati in input è
	 * "true", restituisce false in tutti gli altri casi. Il metodo esegue una
	 * sorta di XOR esteso ad un numero variabile di argomenti.
	 * 
	 * @param items
	 *            lista di valori tra cui eseguire il confronto.
	 * @return valore booleano risultato dello XOR multiplo.
	 */
	public static boolean multipleXOR(boolean... items) {
		boolean result = false;
		for (boolean i : items) {
			if (result && i)
				return false; // se incontra due true esce in quanto la condizione complessiva è necessariamente falsa.
			result = (result ^ i); // altrimenti esegue uno XOR bitwise.
		}
		return result;
	}

	@Deprecated
	public static boolean isEmpty(Object obj) {

		if (obj == null)
			return true;

		Class type = obj.getClass();

		if (type.isArray() && ((Object[]) obj).length > 0)
			return false;

		if (obj instanceof String) {
			return ((String) obj).isEmpty();
		}

		if (obj instanceof Collection) {
			return ((Collection) obj).isEmpty();
		}

		if (obj instanceof Map) {
			return ((Map) obj).isEmpty();
		}

		if (obj instanceof Set) {
			return ((Set) obj).isEmpty();
		}

		if (obj instanceof Vector) {
			return ((Vector) obj).isEmpty();
		}

		return false;

	}

	/**
	 * Genera una stringa random e unique.
	 * 
	 * @return una stringa random e unique.
	 */
	public static String generateRandomUniqueKey() {
		UUID key = UUID.randomUUID();
		return key.toString();
	}
}
