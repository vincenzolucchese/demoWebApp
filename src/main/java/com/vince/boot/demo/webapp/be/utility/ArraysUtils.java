package com.vince.boot.demo.webapp.be.utility;

/**
 * Classe che espone funzioni di utilità legate agli Array.
 * 
 * @author Simone Verlengia
 * @version 1.0
 */
//INTEGRAZIONE-ANEC: classe aggiunta per integrazione ANEC
public class ArraysUtils {
	
	/**
	 * Metodo che verifica la presenza di un oggetto in un array specificato. E'
	 * un metodo alternativo a Arrays.sort() + Arrays.binarySearch() in quanto
	 * non cambia l'ordine presente nell'array ed è più rapido per array di
	 * piccole dimensioni.
	 * 
	 * @param array
	 *            array in cui eseguire la ricerca.
	 * @param item
	 *            oggetto da cercare.
	 * @return boolean che assume valore vero se la stringa è stata trovata.
	 */
	public static boolean unsortedArraySearch(Object[] array, Object item) {
		for (Object element : array) {
			if (element.equals(item))
				return true;
		}
		return false;
	}
	
}
