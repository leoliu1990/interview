package edu.rice.hanoi;

public class Hanoi {
	public static void main(String s[]){
		Tower original = new Tower();
		Tower buffer   = new Tower();
		Tower dest	   = new Tower();
		
		original.add(5);
		original.add(4);
		original.add(3);
		original.add(2);
		original.add(1);
		
		System.out.println(original);
		original.moveDisks(5, buffer, dest);		
		System.out.println(dest);
	}
}