package edu.rice.hanoi;

import java.util.Stack;

public class Tower {
	private Stack<Integer> disks;
	
	public Tower(){
		disks = new Stack<Integer>();
	}
	
	public int add(int t){
		if(!disks.empty() && disks.peek() <= t){
			System.out.println("Error in adding disk");
			return -1;
		}else{
			return disks.push(t);			
		}
	}
	
	public int moveTopTo(Tower t){
		return t.add(disks.pop());
	}
	
	public void moveDisks(int n, Tower buffer, Tower dest){
		if(n > 0){
			moveDisks(n-1, dest, buffer);
			moveTopTo(dest);
			buffer.moveDisks(n-1, this, dest);
		}
	}
	
	public String toString(){
		return disks.toString();
	}
}
