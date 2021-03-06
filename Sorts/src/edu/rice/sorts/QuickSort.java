package edu.rice.sorts;

public class QuickSort {
	public static void quickSort(int array[], int left, int right){
		if(left >= right)
			return;
		int mid = partition(array, left, right);
		quickSort(array, left, mid);
		quickSort(array, mid+1, right);
	}
	
	private static int partition(int array[], int left, int right){
		int pivot = array[left];
		int i = left;
		int j = right;
		
		while(i <= j){
			while(array[i] < pivot) i++;
			while(array[j] > pivot) j--;
			if(i <= j) swap(array, i++, j--);
		}
		
		return i-1;
	}
	
	private static void swap(int array[], int i, int j){
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	public static void main(String s[]){
		int array[] = new int[]{
				3,4,2,6,9,7,6,8,1, 6
		};
		printArray(array);
		quickSort(array, 0, array.length);
		printArray(array);
	}
	
	public static void printArray(int array[]){
		for(int i : array){
			System.out.print(i+" ");
		}
		System.out.println();
	}
}
