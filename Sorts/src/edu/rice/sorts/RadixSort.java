package edu.rice.sorts;

import java.util.ArrayList;

public class RadixSort {
	public static void main (String[] args) {
		int[] arr = {43, 2, 76, 34, 76, 43, 3, 6, 13};
		QuickSort.printArray(arr);
		radixSort(arr);
		QuickSort.printArray(arr);
	}
	
	public static void radixSort (int[] arr) {
		ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> nextBuckets = new ArrayList<ArrayList<Integer>> ();
		
		int cur = 10;
		
		for (int i = 0; i < 10; ++ i) {
			buckets.add(new ArrayList<Integer>());
			nextBuckets.add(new ArrayList<Integer>());
		}
		
		firstBucket(buckets, arr);
		
		while (!bucketHelper(cur, buckets, nextBuckets)) {
			buckets = new ArrayList<ArrayList<Integer>> (nextBuckets);
			nextBuckets.clear();
			for (int i = 0; i < 10; ++ i) {
				nextBuckets.add(new ArrayList<Integer>());
			}
			cur *= 10;
		}
		
		int i = 0;
		for (ArrayList<Integer> bucket : buckets) {
			for (int num : bucket) {
				arr[i ++] = num;
			}
		}
	}
	
	private static boolean bucketHelper (int cur, ArrayList<ArrayList<Integer>> buckets, ArrayList<ArrayList<Integer>> nextBuckets) {
		boolean allZeros = true;
		for (ArrayList<Integer> bucket : buckets) {
			for (int i : bucket) {
				nextBuckets.get((i/cur)%10).add(i);
				if ((i/cur)%10 != 0) allZeros = false;
			}
		}
		return allZeros;
	}
	
	private static void firstBucket (ArrayList<ArrayList<Integer>> buckets, int[] arr) {
		for (int i : arr) {
			buckets.get(i%10).add(i);
		}
	}
}
