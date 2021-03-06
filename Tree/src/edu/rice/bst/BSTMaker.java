package edu.rice.bst;

import edu.rice.tree.BinaryTree;
import edu.rice.tree.Node;

/**
 * @author leo
 * Make BST with minimal height
 *
 */
public class BSTMaker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTMaker bm = new BSTMaker();
		int array[] = new int[]{1,2,3,4,5,6,7,8};
		BinaryTree tree = bm.makeBST(array);
		System.out.println(tree);
	}

	public BinaryTree makeBST(int array[]){
		BinaryTree tree = new BinaryTree();
		tree.setRoot(generateNode(array, 0, array.length-1));
		return tree;
	}
	
	private Node generateNode(int array[], int left, int right){
		if(left == right)
			return new Node(array[left]);
		if(left > right)
			return null;
		
		int mid = (left+right+1)/2;
		Node node = new Node(array[mid]);
		node.setLeft(generateNode(array, left, mid-1));
		node.setRight(generateNode(array, mid+1, right));
		
		return node;
	}
}
