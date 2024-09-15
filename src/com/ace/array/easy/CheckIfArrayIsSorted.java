package com.ace.array.easy;

public class CheckIfArrayIsSorted {

    public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
        System.out.println(checkSortedArrayViaBruteForce(arr));
        System.out.println(checkSortedArrayViaBetterApproach(arr));
    }

    private static boolean checkSortedArrayViaBetterApproach(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkSortedArrayViaBruteForce(int[] arr) {
        int n = arr.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n ; j++){
                if(arr[j]<arr[i]){
                    return false;
                }
            }
        }
        return true;
    }
}
