package edu.rice.bfs;

import java.util.ArrayList;
import java.util.LinkedList;

import edu.rice.tree.BinaryTree;
import edu.rice.tree.Node;
import edu.rice.tree.TreeGenerator;

public class BFS {
	public static void main(String s[]){
		TreeGenerator tg = new TreeGenerator("5321###4##76##8##");
		BinaryTree tree = tg.generateTree();
		
		BFS b = new BFS();
		ArrayList<LinkedList<Node>> list = b.bfs(tree); 
		printLists(list);
	}
	
	public ArrayList<LinkedList<Node>> bfs(BinaryTree tree){
		ArrayList<LinkedList<Node>> list = new ArrayList<LinkedList<Node>>();
		if(tree.getRoot() == null)
			return list;
		
		LinkedList<Node> ll = new LinkedList<Node>();
		LinkedList<Node> backup = new LinkedList<Node>();
		ll.add(tree.getRoot());
		
		while(!ll.isEmpty()){
			list.add(new LinkedList<Node>(ll));
			while(ll.peek() != null){
				Node tmp = ll.remove();
				if(tmp.getLeft() != null && backup.add(tmp.getLeft()));
				if(tmp.getRight() != null && backup.add(tmp.getRight()));
			}
			ll = new LinkedList<Node>(backup);
			backup.clear();
		}
		return list;
	}
	
	public static void printLists(ArrayList<LinkedList<Node>> list){
		for(LinkedList<Node> ll : list){
			while(ll.peek() != null){
				System.out.print(ll.remove());
			}
			System.out.println();
		}
	}
}
