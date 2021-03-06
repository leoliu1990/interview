package edu.rice.subtree;

import edu.rice.tree.BinaryTree;
import edu.rice.tree.Node;
import edu.rice.tree.TreeGenerator;

public class SubtreeChecker {
	public static void main(String s[]){
		TreeGenerator tg1 = new TreeGenerator("5321###4##76##8##");
		TreeGenerator tg2 = new TreeGenerator("321###4##");
		BinaryTree tree1 = tg1.generateTree();
		BinaryTree tree2 = tg2.generateTree();
		
		SubtreeChecker sc = new SubtreeChecker();
		boolean b = sc.isSubtree(tree1, tree2);
		System.out.println(b);
	}
	
	public boolean isSubtree(BinaryTree big, BinaryTree small){
		if(small.isEmpty())
			return true;
		if(big.isEmpty())
			return false;		
		return subtree(big.getRoot(), small.getRoot());
	}
	
	private boolean subtree(Node bignode, Node smallnode){
		if(smallnode == null)
			return true;
		if(bignode == null)
			return false;
		if(match(bignode, smallnode))
			return true;
		return subtree(bignode.getLeft(), smallnode) || subtree(bignode.getRight(), smallnode);
	}
	
	private boolean match(Node n1, Node n2){
		if(n1 == null && n2 == null)
			return true;
		if(n1 == null || n2 == null)
			return false;
		if(n1.getData() != n2.getData())
			return false;
		return match(n1.getLeft(), n2.getLeft()) && match(n1.getRight(), n2.getRight());
	}
}
