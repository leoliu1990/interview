package edu.rice.tree;

public class BinaryTree {
	private Node root;
	
	public BinaryTree(){
		this.setRoot(null);
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
	public boolean isEmpty(){
		return root == null;
	}
	
	public String toString(){
		return serialize(root);		
	}
	
	private String serialize(Node node){
		if(node == null)
			return "#";
		
		String r = "" + node.getData();
		r += serialize(node.getLeft());
		r += serialize(node.getRight());
		
		return r;
	}
}
