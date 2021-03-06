package edu.rice.circular;

import edu.rice.linkedlist.LinkedList;
import edu.rice.linkedlist.Node;

public class CircularHead {
	public static void main(String s[]){
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n6);
		n6.setNext(n7);
		n7.setNext(n4);
		LinkedList list = new LinkedList();
		list.setHead(n1);
		
		CircularHead ch = new CircularHead();
		Node res = ch.findCircularHead(list);
		System.out.println(res);
	}
	
	private Node findCircularHead(LinkedList list){
		Node head = list.getHead();
		Node meet = findMeetPoint(list);
		
		if(head == null || meet == null)
			return null;
		
		while(!head.equals(meet)){
			head = head.getNext();
			meet = meet.getNext();
		}
		
		return head;
	}
	
	private Node findMeetPoint(LinkedList list){
		Node fast = list.getHead();
		Node slow = list.getHead();
		if(fast == null)
			return null;
		
		slow = slow.getNext();
		if(slow != null)
			fast = slow.getNext();
		else
			return null;
		
		while(fast != null && !fast.equals(slow)){
			slow = slow.getNext();
			fast = fast.getNext();
			if(fast != null)
				fast = fast.getNext();
			else
				continue;
		}
		return fast;
	}
}
