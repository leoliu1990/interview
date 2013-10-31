package edu.rice.bst;

import edu.rice.tree.BinaryTree;
import edu.rice.tree.Node;
import edu.rice.tree.TreeGenerator;

public class BSTChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeGenerator tg = new TreeGenerator("132##4##886###9##");
		BinaryTree tree = tg.generateTree();
		BSTChecker bc = new BSTChecker();
		boolean b = bc.isBST(tree.getRoot());
		System.out.println(b);
	}
	
	private boolean isBST(Node node){
		if(node == null)
			return true;
		if(node.getLeft() != null && node.getLeft().getData() > node.getData())
			return false;
		if(node.getRight() != null && node.getRight().getData() < node.getData())
			return false;
		
		return isBST(node.getLeft()) && isBST(node.getRight());
	}
}
