package com.vince.boot.demo.webapp.be.utility;


/**
 * Classe che realizza una struttura ad albero contenenti nodi di tipo stringa.
 * @author   Simone Verlengia
 * @version  1.0.0
 */
public class StringNode extends TreeNode<String>{

	public StringNode(String data) {
		super(data);
	}
	
	public String getString() {
		return super.getData();
	}

	public void setString(String data) {
		super.setData(data);
	}
	
}
