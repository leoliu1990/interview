package edu.rice.insertbits;

public class BitsInsertor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BitsInsertor bi = new BitsInsertor();
		int target = 65;
		int src = 15;
		int res = bi.insertBits(target, src, 2, 5);
		System.out.println(res);
	}
	
	public int insertBits(int target, int src, int start, int end){
		int len = end - start + 1;
		int mask = (1 << len) - 1 << start - 1; // 000011110000
		System.out.println(Integer.toBinaryString(mask));
		int umask = ~ mask;                       // 111100001111
		System.out.println(Integer.toBinaryString(umask));
		int value = mask & src << start - 1;
		return target & umask | value;
	}
}
