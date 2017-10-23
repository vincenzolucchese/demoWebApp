package com.vince.boot.demo.webapp.business;

import java.util.Iterator;
import java.util.stream.IntStream;

public class StaticMaiin {

	public static void main(String[] args) {
		
		IntStream.rangeClosed(0, 99).forEach(Integer::toString);
		
		Iterator<String> dajie = IntStream.rangeClosed(0, 99).mapToObj(Integer::toString).iterator();
		
		while( dajie.hasNext()) {
			System.out.println(dajie);
		}

	}

}
