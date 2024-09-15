package com.ace.array.medium;

/*Problem Statement: Given a matrix, your task is to rotate the matrix 90 degrees clockwise.

Example 1:
Input:
        [[1,2,3],[4,5,6],[7,8,9]]

Output
: [[7,4,1],[8,5,2],[9,6,3]]*/
public class RotateMatrixBy90Degree {
    public static void main(String[] args) {
        int[][] matrx = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int rotated[][] = rotateMatrixBy90DegreeBruteForce(matrx);
        System.out.println("Brute Force Approach: ");
        printMatrix(rotated);
        int rotated2 [][]= rotateMatrixBy90DegreeOptimal(matrx);
        System.out.println("Optimal Approach: ");
        printMatrix(rotated2);

    }

    /*
    Step 1: Transpose the matrix. (transposing means changing columns to rows and rows to columns)
    Step 2: Reverse each row of the matrix.
    * **/
    private static int[][] rotateMatrixBy90DegreeOptimal(int[][] matrix) {
        for(int i=0; i<matrix.length; i++){
            for(int j=i; j<matrix[0].length; j++){
                int temp =matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] =temp;
            }
        }
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length/2; j++){
                int temp =matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] =temp;
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] rotated) {
        for (int i = 0; i < rotated.length; i++) {
            for (int j = 0; j < rotated.length; j++) {
                System.out.print(rotated[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] rotateMatrixBy90DegreeBruteForce(int[][] matrx) {
        int n = matrx.length;
        int[][] rotated = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - 1 - i] = matrx[i][j];
            }
        }
        return rotated;
    }
}
