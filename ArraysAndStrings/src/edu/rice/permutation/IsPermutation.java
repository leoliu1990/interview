package edu.rice.permutation;

import java.util.HashMap;

public class IsPermutation {
	public static void main(String s[]){
		IsPermutation ip = new IsPermutation();
		boolean b = ip.isPermutation("abcdd", "bcdad");
		System.out.println(b);
	}
	private boolean isPermutation(String s1, String s2){
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int len1 = s1.length();
		int len2 = s2.length();
		if ( len1 != len2 ) return false;
		
		for(int i = 0; i < len1; i++){
			if(map.get(s1.charAt(i)) != null)
				map.put(s1.charAt(i), map.get(s1.charAt(i))+1);
			else
				map.put(s1.charAt(i), 1);
		}
		
		for(int j = 0; j < len2; j++){
			if(map.get(s2.charAt(j)) != null){
				map.put(s2.charAt(j), map.get(s2.charAt(j))-1);
				if(map.get(s2.charAt(j)) == 0)
					map.remove(s2.charAt(j));
			}else{
				return false;
			}
		}
		return true;
	}
}
