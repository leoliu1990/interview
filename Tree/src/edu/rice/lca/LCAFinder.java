package edu.rice.lca;

import edu.rice.tree.BinaryTree;
import edu.rice.tree.Node;
import edu.rice.tree.TreeGenerator;

public class LCAFinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeGenerator tg = new TreeGenerator("5321###4##76##8##");
		BinaryTree tree = tg.generateTree();
		LCAFinder lf = new LCAFinder();
		Node res = lf.findLCA(tree.getRoot(), new Node(4), new Node(6));
		
		System.out.println(res);
	}

	public Node findLCA(Node root, Node n1, Node n2){
		if(root == null || root.getData() == n1.getData() || root.getData() == n2.getData())
			return root;
		Node l = findLCA(root.getLeft(), n1, n2);
		Node r = findLCA(root.getRight(), n1, n2);
		
		if(l != null && r != null)
			return root;				
		else if(l != null || r != null)
			return l != null ? l : r;
		else
			return null;
	}
}
