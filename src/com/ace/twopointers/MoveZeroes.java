package com.ace.twopointers;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int [] arr = {0,1,0,3,12};
        moveZeros(arr);
        Arrays.stream(arr).forEach(i->System.out.println(i+ " "));
    }

    private static void moveZeros(int[] arr) {
        int lastNonZeroFoundAt = 0;

        // If the current element is not 0, then we need to
        // append it just in front of last non zero element we found.
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=0){
                arr[lastNonZeroFoundAt++]=arr[i];
            }
        }

        // After we have finished processing new elements,
        // all the non-zero elements are already at the beginning of the array.
        // We just need to fill remaining array with 0's.
        for (int i = lastNonZeroFoundAt; i < arr.length; i++) {
            arr[i] = 0;
        }
    }
}
