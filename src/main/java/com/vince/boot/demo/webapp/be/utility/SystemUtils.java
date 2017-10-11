package com.vince.boot.demo.webapp.be.utility;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Classe che espone funzioni di utilità legate a funzionalità di sistemistiche.
 * 
 * @author Simone Verlengia
 * @version 1.0
 */
//INTEGRAZIONE-ANEC: classe aggiunta per integrazione ANEC
public class SystemUtils {

	/**
	 * Metodo che ritorna l'indirizzo IP locale della macchina.
	 * 
	 * @return L'indirizzo ip locale.
	 */
	public static String getLocalIP() {
		String hostname = null;
		try {
	
			hostname = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			hostname = "";
		}
		return hostname;
	}
	
	/**
	 * Metodo che restituisce la quantità di memoria (in byte) utilizzata dalla JVM.
	 * @return
	 */
	public long getUsedMemory() {
		return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
	}
	
	/**
	 * Metodo che forza una garbage collection della JVM.
	 * @return void
	 */
	public void performGC() {
		for (int i = 0; i < 10; i++) {
			System.gc();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}
}
