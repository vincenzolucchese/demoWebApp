package com.vince.boot.demo.webapp.be.utility;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;


public class MathUtils {
	
	/**
	 * Moltiplica i valori percentuali passati in input e ritorna il prodotto ritrasformato in percentuale con precisione decimale ad 8 cifre.
	 * @param valoreA BigDecimal
	 * @param valoreB BigDecimal
	 * @return BigDecimal 
	 * @throws ApplicationException
	 */
	public static BigDecimal moltiplicaValoriPercentualiOttoCifreDecimali(BigDecimal valoreA, BigDecimal valoreB) throws ApplicationException {
		return moltiplicaValoriPercentualiConPrecisioneDecimale(valoreA, valoreB, 8);
	}

	/**
	 * Moltiplica i valori percentuali passati in input e ritorna il prodotto ritrasformato in percentuale con precisione decimale a 16 cifre.
	 * @param valoreA BigDecimal
	 * @param valoreB BigDecimal
	 * @return BigDecimal 
	 * @throws ApplicationException
	 */
	public static BigDecimal moltiplicaValoriPercentualiSediciCifreDecimali(BigDecimal valoreA, BigDecimal valoreB) throws ApplicationException {
		return moltiplicaValoriPercentualiConPrecisioneDecimale(valoreA, valoreB, 16);
	}
	
	/**
	 * Moltiplica i valori percentuali passati in input e ritorna il prodotto ritrasformato in percentuale con precisione decimale specificabile come parametro.
	 * @param valoreA BigDecimal
	 * @param valoreB BigDecimal
	 * @param precision numero di cifre decimali da usare per la precision del calcolo
	 * @return BigDecimal 
	 * @throws ApplicationException
	 */
	public static BigDecimal moltiplicaValoriPercentualiConPrecisioneDecimale(BigDecimal valoreA, BigDecimal valoreB, int precision) throws ApplicationException {
		BigDecimal prodotto = null;
		BigDecimal fattoreA = null;
		BigDecimal fattoreB = null;
		
		fattoreA = valoreA.divide(new BigDecimal(100));
		fattoreB = valoreB.divide(new BigDecimal(100));
		
		prodotto = moltiplicaValoriConPrecisioneDecimale(fattoreA, fattoreB, precision);

		return prodotto.multiply(new BigDecimal(100));
	}
	
	/**
	 * Moltiplica i fattori valoreA e valoreB imponendo la precisione a 8 cifre decimali e  l'arrotondamento RoundingMode.HALF_DOWN
	 * @param valoreA BigDecimal
	 * @param valoreB BigDecimal
	 * @return
	 * @throws ApplicationException
	 */
	public static BigDecimal moltiplicaValoriOttoCifreDecimali(BigDecimal valoreA, BigDecimal valoreB) throws ApplicationException {
		return moltiplicaValoriConPrecisioneDecimale(valoreA, valoreB, 8);
	}
	
	/**
	 * Moltiplica i fattori valoreA e valoreB imponendo la precisione a 16 cifre decimali e  l'arrotondamento RoundingMode.HALF_DOWN
	 * @param valoreA BigDecimal
	 * @param valoreB BigDecimal
	 * @return
	 * @throws ApplicationException
	 */
	public static BigDecimal moltiplicaValoriSediciCifreDecimali(BigDecimal valoreA, BigDecimal valoreB) throws ApplicationException {
		return moltiplicaValoriConPrecisioneDecimale(valoreA, valoreB, 16);
	}
	
	/**
	 * Moltiplica i fattori valoreA e valoreB imponendo una precisione di cifre decimali specificata come parametro di input
	 * e  l'arrotondamento RoundingMode.HALF_DOWN
	 * @param valoreA BigDecimal
	 * @param valoreB BigDecimal
	 * @param precision numero di cifre decimali da usare per la precision del calcolo
	 * @return
	 * @throws ApplicationException
	 */
	public static BigDecimal moltiplicaValoriConPrecisioneDecimale(BigDecimal valoreA, BigDecimal valoreB, int precision) throws ApplicationException {
		BigDecimal ritorno = null;
		try {
			MathContext mc = new MathContext(precision, RoundingMode.HALF_DOWN);
			ritorno = valoreA.multiply(valoreB, mc);
		} catch (ArithmeticException e) {
			throw new ApplicationException(e);
		}
		return ritorno;
	}
}
