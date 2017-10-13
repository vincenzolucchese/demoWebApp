package com.vince.boot.demo.webapp.be.utility;

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
