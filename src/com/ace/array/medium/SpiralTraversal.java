package com.ace.array.medium;

import java.util.ArrayList;
import java.util.List;

/*Problem Statement: Given a Matrix, print the given matrix in spiral order.
        Example 1:
Input: Matrix[][] = { { 1, 2, 3, 4 },
        { 5, 6, 7, 8 },
        { 9, 10, 11, 12 },
        { 13, 14, 15, 16 } }

Outhput: 1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10.
Explanation: The output of matrix in spiral form.

        Example 2:
Input: Matrix[][] = { { 1, 2, 3 },
        { 4, 5, 6 },
        { 7, 8, 9 } }

Output: 1, 2, 3, 6, 9, 8, 7, 4, 5.
Explanation: The output of matrix in spiral form.*/
public class SpiralTraversal {
    public static void main(String[] args) {
        //Matrix initialization.
        int[][] mat = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        List<Integer> ans = printSpiral(mat);
        ans.stream().forEach(a-> System.out.print(a+" "));
    }

    private static List<Integer> printSpiral(int[][] mat) {
        // Define ans list to store the result.
        List<Integer> ans = new ArrayList<>();
        int noOfRows = mat.length;
        int noOfCols = mat[0].length;
        int top = 0, bottom = noOfRows - 1, left = 0, right = noOfCols - 1;

        while (top<=bottom && left <=right){

            //for moving from left to right
            for(int i=left; i<=right; i++){
                ans.add(mat[top][i]);
            }
            top++;

            //for moving from top to bottom

            for(int i=top ; i<=bottom; i++){
                ans.add(mat[i][right]);
            }
            right --;

            // For moving right to left.
            if(top <=bottom){
                for (int i=right; i>=left; i--){
                    ans.add(mat[bottom][i]);
                }
                bottom --;
            }

            // For moving bottom to up.
            if(left <=right){
                for (int i = bottom; i >= top; i--){
                    ans.add(mat[i][left]);
                }
                left++;
            }
        }
        return ans;
    }
}
