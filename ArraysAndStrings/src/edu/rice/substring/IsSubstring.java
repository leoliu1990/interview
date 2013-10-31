package edu.rice.substring;

public class IsSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsSubstring is = new IsSubstring();
		boolean b = is.isSubstring("hellomoto", "moto");
		System.out.println(b);
	}
	
	public boolean isSubstring(String s, String t){
		int lens = s.length();
		int lent = t.length();
		if(lens < lent || lent == 0)
			return false;
		
		int count = 0;
		while(count < lens-lent+1){
			int i;
			for(i = 0; i < lent; i++){
				if(s.charAt(count+i) != t.charAt(i)){
					count++;
					break;
				}
			}
			if(i == lent)
				return true;
		}
		return false;
	}
}
