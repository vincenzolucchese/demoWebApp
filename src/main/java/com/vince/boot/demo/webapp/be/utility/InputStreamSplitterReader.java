package com.vince.boot.demo.webapp.be.utility;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * Classe derivata dall'oggetto java.io.InputStreamReader. E' intesa per essere utilizzata come filtro per convertire in tempo reale
 * stream di dati in formato testo fixed-length privi di separatore di riga. Questa classe legge lo stream dati restituendone uno
 * identico ma addizionato di separatori di riga.
 * Per poter istanziare questo reader è necessario indicare sempre la lunghezza massima della riga di intestazione e delle righe
 * dei dati nonchè il codice numerico del carattere da usare come separatore di riga.
 * 
 * N.B.: eventuali caratteri di fine riga già presenti nello stream vengono eliminati.
 *  
 * @author   Simone Verlengia
 * @version  1.0.0
 * @see  InputStreamReader
 */
public class InputStreamSplitterReader extends InputStreamReader {
	
	int headerMaxLength; //lunghezza dell'header
	int dataRowMaxLength; //lunghezza della riga
	int rowSplitter; //carattere da usare come separatore di riga
	int rowMaxLength; //variabile che indica l'attuale lunghezza di riga (comincia pari a headerMaxLength e diventa poi pari a dataRowMaxLength)
	int position = 0; //puntatore che tiene traccia della posizione del carattere rispetto alla riga di appartenenza (varia da 1 a rowMaxLength e viene resettato a 0 ad ogni nuova riga)
	
    /**
     * Creates an InputStreamReader that uses the default charset.
     *
     * @param  in InputStream sorgente.
     * @param  headerMaxLength Lunghezza massima della riga di intestazione.
     * @param  dataRowMaxLength Lunghezza massima delle righe dei dati.
     * @param  rowSplitter Codice del carattere da utilizzare come separatore di riga. 
     */	
	public InputStreamSplitterReader(InputStream in, int headerMaxLength, int dataRowMaxLength, int rowSplitter) {
		super(in);
		this.headerMaxLength = headerMaxLength;
		this.dataRowMaxLength = dataRowMaxLength;
		this.rowSplitter = rowSplitter;
		rowMaxLength = headerMaxLength;
	}

    /**
     * Creates an InputStreamReader that uses the named charset.
     *
     * @param  in
     *         An InputStream
     *
     * @param  charsetName
     *         The name of a supported
     *         {@link java.nio.charset.Charset </code>charset<code>}
     * @param  headerMaxLength 
     * 			Lunghezza massima della riga di intestazione.
     * @param  dataRowMaxLength L
     * 			Lunghezza massima del singolo record in caratteri (non in byte).
     * @param  rowSplitter 
     * 			Codice del carattere da utilizzare come separatore di riga. 
     *
     * @exception  UnsupportedEncodingException
     *             If the named charset is not supported
     */
	public InputStreamSplitterReader(InputStream in, String charsetName, int headerMaxLength, int dataRowMaxLength, int rowSplitter)
			throws UnsupportedEncodingException {
		super(in, charsetName);
		this.headerMaxLength = headerMaxLength;
		this.dataRowMaxLength = dataRowMaxLength;
		this.rowSplitter = rowSplitter;	
		rowMaxLength = headerMaxLength;
	}

    /**
     * Creates an InputStreamReader that uses the given charset. </p>
     *
     * @param  in       An InputStream
     * @param  cs       A charset
     * @param  headerMaxLength Lunghezza massima della riga di intestazione.
     * @param  dataRowMaxLength Lunghezza massima delle righe dei dati.
     * @param  rowSplitter Codice del carattere da utilizzare come separatore di riga. 
     */
	public InputStreamSplitterReader(InputStream in, Charset cs, int headerMaxLength, int dataRowMaxLength, int rowSplitter) {
		super(in, cs);
		this.headerMaxLength = headerMaxLength;
		this.dataRowMaxLength = dataRowMaxLength;
		this.rowSplitter = rowSplitter;	
		rowMaxLength = headerMaxLength;
	}

    /**
     * Creates an InputStreamReader that uses the given charset decoder.  </p>
     *
     * @param  in       An InputStream
     * @param  dec      A charset decoder
     * @param  headerMaxLength Lunghezza massima della riga di intestazione.
     * @param  dataRowMaxLength Lunghezza massima delle righe dei dati.
     * @param  rowSplitter Codice del carattere da utilizzare come separatore di riga. 
     */
	public InputStreamSplitterReader(InputStream in, CharsetDecoder dec, int headerMaxLength, int dataRowMaxLength, int rowSplitter) {
		super(in, dec);
		this.headerMaxLength = headerMaxLength;
		this.dataRowMaxLength = dataRowMaxLength;
		this.rowSplitter = rowSplitter;	
		rowMaxLength = headerMaxLength;
	}

    /**
     * Read a single character.
     *
     * @return The character read, or -1 if the end of the stream has been
     * reached
     *
     * @exception IOException If an I/O error occurs
     */
	@Override
	public int read() throws IOException {
		int c = 0;
		
		position ++;

		//se ha raggiunto la lunghezza massima della riga inserisce il separatore di riga
		if (position == rowMaxLength+1) {
			c=rowSplitter;
			position = 0;			
			rowMaxLength = dataRowMaxLength; //dopo la prima riga (header) la lunghezza deve essere sempre quella della riga dei dati 
		}
		//altrimenti legge il normale carattere presente nello stream originale
		else {
			//eventuali caratteri di separazione di riga già presenti nello stream vengono scartati, si ferma al primo carattere valido
			//while ((c = super.read()) == rowSplitter){}

  			c = super.read();
			if(c==rowSplitter || c == 13){ //Sostituisce i caratteri di fine riga ed i CR con spazi
				c = 20;
			}			

		}
		return c;
	}
	
    /**
     * Read characters into a portion of an array.
     *
     * @param cbuf Destination buffer
     * @param offset Offset at which to start storing characters
     * @param length Maximum number of characters to read
     *
     * @return The number of characters read, or -1 if the end of the
     * stream has been reached
     *
     * @exception IOException If an I/O error occurs
     */
	@Override
    public int read(char cbuf[], int offset, int length) throws IOException {
    	int charNum = 0;
    	
        if ((offset <  0) || (offset  > cbuf.length) || (length <  0) ||
                ((offset + length)  > cbuf.length) || ((offset + length) <  0)) {
                throw new IndexOutOfBoundsException();
        }
        
        if (length == 0)
            return 0;
    	
        for (int i = 0; i < length; i++)
        {
           int c = this.read();
           if (c==-1) break;
           charNum ++;
           cbuf[offset+i] = (char) c;
        }
        
        if (charNum==0) charNum = -1;
        
    	return charNum;
    }
}
