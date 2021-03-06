package edu.rice.stringcompress;

public class StringCompress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringCompress sc = new StringCompress();
		String res = sc.compress("ddddegggtddddi");
		System.out.println(res);
	}
	
	private String compress(String s){
		StringBuffer sb = new StringBuffer();
		int len = s.length(), count = 1;
		char cur = s.charAt(0);
		
		for(int i = 1; i < len; i++){
			if(s.charAt(i) == cur){
				count++;
			}else{
				sb.append(cur);
				sb.append(count);
				cur = s.charAt(i);
				count = 1;
			}
		}
		sb.append(cur);
		sb.append(count);
		
		String res = sb.toString();
		if(res.length() >= len) res = s;
		
		return res;
	}
}
