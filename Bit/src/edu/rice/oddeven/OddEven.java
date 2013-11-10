package edu.rice.oddeven;

public class OddEven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OddEven oe = new OddEven();
		int t = 234679;
		int p = oe.swapOddEven(t);
		System.out.println(Integer.toBinaryString(t));
		System.out.println(Integer.toBinaryString(p));
	}

	public int swapOddEven(int t){
		return (t & 0xaaaaaaaa) >> 1 | (t & 0x55555555) << 1;
	}
}
