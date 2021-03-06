package edu.rice.duplicates;

import java.util.HashSet;

import edu.rice.linkedlist.*;

public class RemoveDupls {
	public static void main(String s[]){
		int array[] = new int[]{
				1,2,3,4,5,6,5,4,3
		};
		ListGenerater lg = new ListGenerater(array);
		LinkedList list = lg.generateList();
		System.out.println(list);
		
		RemoveDupls rd = new RemoveDupls();
//		rd.removeDupls(list);
		rd.removeDuplsInSpace(list);
		System.out.println(list);
		
	}
	
	@SuppressWarnings("unused")
	private void removeDupls(LinkedList list){
		HashSet<Integer> set = new HashSet<Integer>();
		Node head = list.getHead();
		Node prev = null;
		while(head != null){
			if(set.contains(head.getData())){
				prev.setNext(head.getNext());
			}else{
				set.add(head.getData());
				prev = head;
			}
			head = head.getNext();
		}
	}
	
	private void removeDuplsInSpace(LinkedList list){
		Node head = list.getHead();
		Node tmp  = head;
		Node prev = null;
		
		while(tmp != null){
			Node n;
			for(n = head; !n.equals(tmp); n = n.getNext()){
				if(n.getData() == tmp.getData()){
					prev.setNext(tmp.getNext());
					break;
				}
			}
			if(n == tmp){
				prev = tmp;
			}
			tmp = tmp.getNext();
		}
	}
}
