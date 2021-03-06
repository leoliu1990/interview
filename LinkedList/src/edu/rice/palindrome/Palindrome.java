package edu.rice.palindrome;

import edu.rice.linkedlist.LinkedList;
import edu.rice.linkedlist.ListGenerater;
import edu.rice.linkedlist.Node;

public class Palindrome {
	
	private Node head;

	private boolean isPalindrome(Node cur){
		if(head == null)
			return true;
		boolean prev = true;		
		if(cur.getNext() != null){
			prev = isPalindrome(cur.getNext());
		}
		if(!prev)
			return false;
		else
			prev = head.getData() == cur.getData();
		head = head.getNext();
		return prev;
	}

	public Palindrome(LinkedList list){
		head = list.getHead();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListGenerater lg = new ListGenerater(new int[]{1,2,3,2,1});
		LinkedList list = lg.generateList();
		
		Palindrome p = new Palindrome(list);
		boolean b = p.isPalindrome(list.getHead());
		System.out.println(b);
	}
}
