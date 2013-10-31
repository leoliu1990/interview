package edu.rice.linkedlist;

public class Node {
	private Node next = null;
	private int data;
	
	public Node(int data){this.setData(data);}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	public String toString(){
		String s = new String();
		s = ""+data;
		return s;
	}
}
