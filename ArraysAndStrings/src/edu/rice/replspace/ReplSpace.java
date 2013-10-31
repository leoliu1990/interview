package edu.rice.replspace;

public class ReplSpace {
	public static void main(String s[]){
		ReplSpace rs = new ReplSpace();
		char a[] = rs.replSpace("hello moto  ".toCharArray());
		System.out.println(a);
	}
	
	private char[] replSpace(char a[]){
		StringBuffer sb = new StringBuffer();
		int len = a.length;
		int end = len-1;
		while(a[end] == ' ') end--;
		for(int i = 0; i <= end; i++){
			if(a[i] == ' ')
				sb.append("%20");
			else
				sb.append(a[i]);
		}
		return sb.toString().toCharArray();
	}
}
