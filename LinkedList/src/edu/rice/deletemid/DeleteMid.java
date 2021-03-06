package edu.rice.deletemid;

import edu.rice.linkedlist.*;

public class DeleteMid {
	public static void main(String s[]){
		ListGenerater lg = new ListGenerater(new int[]{1,2,3,4,5});
		LinkedList list = lg.generateList();
		
		DeleteMid dm = new DeleteMid();
		dm.deleteMid(list);
		System.out.println(list);
	}
	
	private void deleteMid(LinkedList list){
		Node fast = list.getHead();
		if(fast == null)
			return;
		Node slow = list.getHead();
		Node prev = null;
		boolean mov = true;
		
		while(fast != null){
			fast = fast.getNext();
			mov ^= true;
			
			if(mov){
				prev = slow;
				slow = slow.getNext();
			}
		}
		
		if(prev != null){
			prev.setNext(slow.getNext());
		}
	}
}
