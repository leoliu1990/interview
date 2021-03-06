package edu.rice.matrixrotation;

public class MatrixRotation {
	public static void main(String s[]){
		MatrixRotation r = new MatrixRotation();
		int matrix[][] = new int[][]{
				{1,2,3,4},
				{1,2,3,4},
				{1,2,3,4},
				{1,2,3,4}
		};		
		r.printMatrix(matrix);
		r.rotate(matrix);
		r.printMatrix(matrix);
	}
	
	private void rotate(int matrix[][]){
		int len = matrix.length;
		for(int i = 0; i <= (len-1)/2; i++){
			for(int j = 0; j < len-2*i-1; j++){
				int backup = matrix[i][i+j];
				matrix[i][i+j]             = matrix[i+j][len-1-i];
				matrix[i+j][len-1-i]       = matrix[len-1-i][len-1-i-j];
				matrix[len-1-i][len-1-i-j] = matrix[len-1-i-j][i];
				matrix[len-1-i-j][i]       = backup;
			}
		}
	}
	
	private void printMatrix(int matrix[][]){
		int len = matrix.length;
		for(int i = 0; i < len; i++){
			for(int j = 0; j < len; j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
}
