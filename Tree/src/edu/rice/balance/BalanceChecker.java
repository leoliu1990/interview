package edu.rice.balance;

import edu.rice.tree.BinaryTree;
import edu.rice.tree.Node;
import edu.rice.tree.TreeGenerator;

public class BalanceChecker {
	public static void main(String s[]){
		BinaryTree bt = new TreeGenerator("1234####56##7##").generateTree();
		BalanceChecker bc = new BalanceChecker();
		boolean b = bc.isBalanced(bt);
		System.out.println(b);
	}
	
	private boolean isBalanced(BinaryTree tree){
		return heightDiff(tree.getRoot()) >= 0 ? true : false;
	}
	
	private int heightDiff(Node node){
		if(node == null)
			return 0;
		
		int left_height  = heightDiff(node.getLeft());
		int right_height = heightDiff(node.getRight());
		
		if(left_height < 0 || right_height < 0 || Math.abs(left_height-right_height) > 1)
			return -1;
		else
			return Math.max(left_height, right_height) + 1;
	}
}
