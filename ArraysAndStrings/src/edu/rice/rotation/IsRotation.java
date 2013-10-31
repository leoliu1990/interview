package edu.rice.rotation;

import edu.rice.substring.*;

public class IsRotation {
	public static void main(String s[]){
		IsRotation ir = new IsRotation();
		boolean b = ir.isRotation("hello", "olhel");
		System.out.println(b);
	}
	
	private boolean isRotation(String s, String t){
		if(s.length() != t.length()) 
			return false;
		String tt = t+t;
		IsSubstring is = new IsSubstring();
		if(is.isSubstring(tt, s))
			return true;
		else
			return false;
	}
}
