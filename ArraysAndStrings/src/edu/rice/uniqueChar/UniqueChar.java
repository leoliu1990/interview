package edu.rice.uniqueChar;

import java.util.HashSet;

public class UniqueChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueChar uc = new UniqueChar();
		boolean b = uc.hasUniqueChar("abcdd");
		System.out.println(b);
	}
	
	private boolean hasUniqueChar(String s){
		HashSet<Character> set = new HashSet<Character>();
		int len = s.length();
		for(int i = 0; i < len; i++){
			if(!set.add(s.charAt(i))){
				return false;
			}
		}
		return true;
	}

}
