package edu.rice.pathsum;

import edu.rice.tree.BinaryTree;
import edu.rice.tree.Node;
import edu.rice.tree.TreeGenerator;

public class PathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeGenerator tg = new TreeGenerator("5322###4##26##7##");
		BinaryTree tree = tg.generateTree();
		
		PathSum ps = new PathSum();
		ps.pathSum(tree.getRoot(), 7);
	}
	
	public void pathSum(Node node, int sum){
		int depth = getDepth(node);
		int stack[] = new int[depth];		
		isSumTo(stack, node, 0, sum);
	}

	public void isSumTo(int stack[], Node node, int depth, int sum){
		if(node == null)
			return;
		stack[depth] = node.getData();
		
		int tmp = 0;
		for(int i = depth; i >= 0; i--){
			tmp += stack[i];
			if(tmp == sum)
				printRoute(stack, i, depth);
		}
		
		isSumTo(stack, node.getLeft(), depth+1, sum);
		isSumTo(stack, node.getRight(), depth+1, sum);
	}
	
	private void printRoute(int stack[], int start, int end){
		System.out.print("[ ");
		for(int i = start; i <= end; i++){
			System.out.print(stack[i]+" ");
		}
		System.out.println("]");
	}
	
	private int getDepth(Node node){
		if(node == null)
			return 0;
		else return Math.max(getDepth(node.getLeft())+1, getDepth(node.getRight())+1);
	}
}
