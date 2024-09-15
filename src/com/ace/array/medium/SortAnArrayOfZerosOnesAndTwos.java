package com.ace.array.medium;

import java.util.Arrays;

public class SortAnArrayOfZerosOnesAndTwos {
    public static void main(String[] args) {
        int arr[] = {1,2,0,0,2,0,1};
        sortArrayUsingBruteForce(arr);
        sortArrayUsingBetterApproach(arr);
        sortArrayUsingBestApproach(arr);
    }

    private static void sortArrayUsingBestApproach(int[] arr) {
        int n = arr.length;
        int low=0, mid=0, high=n-1;

        while (mid<=high){
            if(arr[mid] == 0){
                // swapping arr[low] and arr[mid]
                int temp =arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                low++;
                mid++;
            } else if(arr[mid] == 1){
                mid++;
            } else {
                // swapping arr[high] and arr[mid]
                int temp = arr[mid];
                arr[mid]=arr[high];
                arr[high]=temp;
                high--;
            }
        }

        System.out.println("Array after sorting using best approach: ");
        System.out.println(Arrays.toString(arr));
    }

    private static void sortArrayUsingBetterApproach(int[] arr) {
        int cntZero=0, cntOne=0, cntTwo=0;
        for(int i=0; i<arr.length;i++){
            if(arr[i]==0){
                cntZero++;
            } else if(arr[i]==1){
                cntOne++;
            } else {
                cntTwo++;
            }
        }

        for(int i=0; i< cntZero; i++){
            arr[i]=0;
        }
        for(int i=cntZero; i< cntZero+cntOne; i++){
            arr[i]=1;
        }
        for(int i=cntZero+cntOne; i< cntOne+cntTwo; i++){
            arr[i]=2;
        }
        System.out.println("Array after sorting using better approach: ");
        System.out.println(Arrays.toString(arr));
    }

    private static void sortArrayUsingBruteForce(int[] arr) {
        Arrays.sort(arr);//complexity : O(nlogn)
        System.out.println("Array after sorting using brute force approach: ");
        System.out.println(Arrays.toString(arr));
    }
}
