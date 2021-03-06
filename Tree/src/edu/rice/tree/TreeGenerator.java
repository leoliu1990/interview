package edu.rice.tree;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TreeGenerator {
	private String data;
	
	public TreeGenerator(String data){
		this.data = data;
	}
	
	public BinaryTree generateTree(){
		InputStream in = new ByteArrayInputStream(data.getBytes());
		BinaryTree tree = new BinaryTree();
		try {
			tree.setRoot(getNode(in));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tree;
	}
	
	private Node getNode(InputStream in) throws IOException{
		char c = (char) in.read();
		if(c == '#')
			return null;
		
		Node node = new Node(c-'0');
		node.setLeft(getNode(in));
		node.setRight(getNode(in));
		
		return node;
	}
	
	public static void main(String s[]){
		String str = new String("1234####56##7##");
		TreeGenerator tg = new TreeGenerator(str);
		BinaryTree bt = tg.generateTree();
		
		System.out.println(bt);
	}
}
