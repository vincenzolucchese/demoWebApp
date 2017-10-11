package com.vince.boot.demo.webapp.be.utility;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe di tipo generic che realizza una struttura ad albero.
 * @author   Simone Verlengia
 * @version  1.0.0
 */
public class TreeNode<T> {
	
	        private T data;
	        private TreeNode<T> parent;
	        private List<TreeNode<T>> children;
	        
	        public TreeNode() {
	        	super();
	            this.children = new ArrayList<TreeNode<T>>();
	        }

	        public TreeNode(T data) {
	        	super();
	            this.data = data;
	            this.children = new ArrayList<TreeNode<T>>();
	        }
	                
	        public T getData() {
	        	return data;
	        }
	        
	        public void setData(T data) {
	        	this.data = data;
	        }

			public void setParent(TreeNode<T> parent) {
				this.parent = parent;
			}

			public TreeNode<T> getParent() {
				return parent;
			}

			public void setChildren(List<TreeNode<T>> children) {
				this.children = children;
				for (TreeNode<T> c : children) {
					c.setParent(this);
				}
			}

			public List<TreeNode<T>> getChildren() {
				return children;
			}
			
			public void addChildren(TreeNode<T> treeNode) {
				this.getChildren().add(treeNode);
				treeNode.setParent(this);
			}
			
			public void removeChildren(TreeNode<T> treeNode) {
				this.getChildren().remove(treeNode);
				treeNode.setParent(null);
			}
	    
}