package com.ace.array.easy;

import java.util.Arrays;

public class SecondSmallestAndLargestElement {
    public static void main(String[] args) {
        int[] array = {5, 2, 1, 6, 3};
        secondLargestElementByBruteForce(array);
        secondLargestElementBetterApproach(array);
    }

    /*
     * Only works if there are no duplicates
     * Time Complexity: O(NlogN), For sorting the array
     * Space Complexity: O(1)
     * */
    private static void secondLargestElementByBruteForce(int[] arr) {
        Arrays.sort(arr);
        int small = arr[1];
        int large = arr[arr.length - 2];
        System.out.println("Second smallest is " + small);
        System.out.println("Second largest is " + large);
    }


    /*
    * Find the smallest and largest element in the array in a single traversal
      After this, we once again traverse the array and find an element that is just greater than the smallest element we just found.
      Similarly, we would find the largest element which is just smaller than the largest element we just found
        Indeed, this is our second smallest and second largest element.*/
    private static void secondLargestElementBetterApproach(int[] arr) {
        int n = arr.length;
        if (n == 0 || n == 1) {
            System.out.print(-1);
            System.out.print(" ");
            System.out.print(-1);
            System.out.print("\n");
        }
        int small = Integer.MAX_VALUE;
        int second_small = Integer.MAX_VALUE;
        int large = Integer.MIN_VALUE;
        int second_large = Integer.MIN_VALUE;

        int i;
        for (i = 0; i < n; i++) {
            small = Math.min(small, arr[i]);
            large = Math.max(large, arr[i]);
        }

        for (i = 0; i < n; i++) {
            if (arr[i] < second_small && arr[i] != small) {
                second_small = arr[i];
            }
            if (arr[i] > second_large && arr[i] != large) {
                second_large = arr[i];
            }
        }
        System.out.println("Second smallest is " + second_small);
        System.out.println("Second largest is " + second_large);
    }


}
