package edu.rice.linkedlist;

import java.util.Random;

public class ListGenerater {
	private int size;
	private int[] data;
	
	public ListGenerater(int size){
		this.size = size;
		this.data = null;
	}
	
	public ListGenerater(int[] data){
		this.data = data;
		this.size = data.length;
	}
	
	public LinkedList generateList(){
		LinkedList list = new LinkedList();
		
		if(this.data == null){
			Random rand = new Random();
			
			for(int i = 0; i < size; i++){
				list.appendToTail(rand.nextInt());
			}
		}else{
			for(int i = 0; i < size; i++){
				list.appendToTail(data[i]);
			}
		}
		return list;
	}
}
