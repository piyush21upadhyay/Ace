package com.ace.array.easy;

import java.util.HashSet;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 3, 4, 5};
        removeDupViaBruteForce(arr);
        removeDupViaBetterApproach(arr);

    }

    private static void removeDupViaBetterApproach(int[] arr) {
        int i=0;
        for (int j=1; j<arr.length; j++){
            if(arr[i] != arr[j]){
                i++;
                arr[i] = arr[j];
            }
        }
        System.out.println("The array after removing duplicate elements is ");
        for (int k = 0; k < i+1; k++) {
            System.out.print(arr[k] + " ");
        }
    }

    private static void removeDupViaBruteForce(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int number: arr){
            set.add(number);
        }

        set.stream().iterator().forEachRemaining(System.out::print);
    }
}
