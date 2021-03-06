package edu.rice.linkedlist;

import edu.rice.linkedlist.Node;

public class LinkedList {
	private Node head = null;
	private int size;
	
	public LinkedList(){this.size = 0;}

	public int getSize() {
		return size;
	}
	
	public Node getHead(){
		return head;
	}
	
	public void setHead(Node node){
		this.head = node;
	}
	
	public void appendToTail(int data){
		if(head == null){
			head = new Node(data);
		}else{
			Node tmp = head;
			while(tmp.getNext() != null)
				tmp = tmp.getNext();
			tmp.setNext(new Node(data));
		}
		this.size++;
	}
	
	public boolean deleteFirst(int data){
		Node tmp = head;
		Node prev = null;
		while(tmp != null && tmp.getData() != data){
			prev = tmp;
			tmp = tmp.getNext();
		}
		if(tmp == null)
			return false;
		if(prev == null){
			head = null;
		}else{
			prev.setNext(tmp.getNext());
		}
		this.size--;
		return true;
	}
	public String toString(){
		StringBuffer sb = new StringBuffer();
		Node tmp = head;
		while(tmp != null){
			sb.append(tmp.toString());
			sb.append(" ");
			tmp = tmp.getNext();
		}
		return sb.toString();
	}
}
