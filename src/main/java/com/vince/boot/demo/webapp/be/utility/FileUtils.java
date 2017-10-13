package com.vince.boot.demo.webapp.be.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class FileUtils {
	
	/**
	 * Metodo che copia un file sorgente su un file destinazione specificato.
	 * 
	 * @param f1
	 *            file sorgente
	 * @param f2
	 *            file destinazione
	 * @throws IOException
	 */
	public static void copyfile(File f1, File f2) throws IOException {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(f1);

			// For Append the file.
			// OutputStream out = new FileOutputStream(f2,true);

			// For Overwrite the file.
			out = new FileOutputStream(f2);

			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
		} finally { // //CAST_202 + CAST_203 (CAST_COMMONS)
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					TraceLogger.traceError("Errore chiusura InputStream.",
							Utils.class, e);
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					TraceLogger.traceError("Errore chiusura OutputStream.",
							Utils.class, e);
				}
			}
		}
	}

	/**
	 * Metodo che crea una cartella temporanea. (Utile per gli unzip)
	 * 
	 * @param folderName nome della cartella.
	 * @return cartella temporanea.
	 */
	public static File createTempFolder(String folderName) throws ApplicationException {
		File tempDir = null;

		try {
			tempDir = new File(System.getProperty("java.io.tmpdir"), folderName);
		} catch (Exception e) {
			throw new ApplicationException("Errore durante la creazione della cartella temporanea.", e);
		}

		if (!tempDir.mkdirs())
			throw new ApplicationException("Errore durante la creazione della cartella temporanea.");

		return tempDir;
	}

	/**
	 * Metodo che, data una directory, la elimina.
	 * @param folder directory da eliminare
	 */
	public static void deleteFolder(File folder) {
		if (folder != null) {
			if (folder.listFiles().length != 0) {
				for (File subFile : folder.listFiles()) {
					subFile.delete();
				}
			}
			folder.delete();
		}
	}

	/**
	 * Recupera il file CSV in una data cartella. (Presuppone che all'interno della cartella ci sia soltanto un file csv.
	 * 
	 * @param folder cartella che contiene, tra gli altri, il file CSV.
	 * @return il file CSV
	 * @throws ApplicationException se trova nessuno o più di un file nella cartella.
	 */
	public static File getCsvFileFromFolder(File folder) throws ApplicationException {
		File csvFile = null;

		/* Creo un filtro per recuperare i file csv nella cartella */
		FilenameFilter filter = new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
	               if(name.lastIndexOf('.')>0) {
	                  String str = name.substring(name.lastIndexOf('.'));
	                  if (str.equalsIgnoreCase(".csv"))
	                     return true;
	               }
	               return false;
			}
		};

		/* Applico il filtro */
		File[] csvFiles = folder.listFiles(filter);

		/* Controllo che ci sia soltanto un file csv all'interno della cartella come da specifiche */
		if (csvFiles == null || csvFiles.length<1) {
			throw new ApplicationException("File CSV non trovato.");
		} else if (csvFiles.length>1) {
			throw new ApplicationException("Trovati "+csvFiles.length+" file CSV.");
		}

		for (File file : csvFiles) {
			csvFile = file;
		}

		return csvFile;
	}
}
