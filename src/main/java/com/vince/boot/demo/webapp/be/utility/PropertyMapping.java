package com.vince.boot.demo.webapp.be.utility;

import java.lang.reflect.Method;

/**
 * Classe contenitore che raggruppa le informazioni necessarie ad eseguire il mapping
 * (finalizzato alla copia) delle proprietà semplici da un tipo di oggetto ad un altro.
 *
 * @author  Simone Verlengia
 * @version 1.0.0
 *
 */
public class PropertyMapping {
	
	private Method accessor;
	private Method mutator;
	
	public PropertyMapping(Method accessor, Method mutator) {
		this.accessor = accessor;
		this.mutator = mutator;
	}
	
	public void setAccessor(Method accessor) {
		this.accessor = accessor;
	}
	
	public Method getAccessor() {
		return accessor;
	}
	
	public void setMutator(Method mutator) {
		this.mutator = mutator;
	}
	
	public Method getMutator() {
		return mutator;
	}	

}
