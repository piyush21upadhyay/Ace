package com.ace.array.medium;

/*
There’s an array ‘A’ of size ‘N’ with an equal number of positive and negative elements.
Without altering the relative order of positive and negative elements,
you must return an array of alternately positive and negative values.

Note: Start the array with positive elements.

Example 1:

Input:
arr[] = {1,2,-4,-5}, N = 4
Output:
1 -4 2 -5
*
**/
public class ReArrangeArrayElementsBySign {
    public static void main(String[] args) {
        int[] arr = {1, 2, -4, -5};
        reArrangeArrayElementsBySign(arr);
    }

    private static void reArrangeArrayElementsBySign(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        int pos = 0, neg = 1;

        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0) {
                temp[pos] = arr[i];
                pos += 2;
            } else {
                temp[neg] = arr[i];
                neg += 2;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(temp[i] + " ");
        }
    }
}
