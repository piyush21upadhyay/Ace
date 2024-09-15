package com.ace.array.easy;


import java.util.Arrays;

public class LargestElementInAnArray {
    public static void main(String[] args) {
        int[] array = {5, 2, 1, 6, 3};
        System.out.println("Largest element in the array is: " + largestElementByBruteForce(array));
        System.out.println("Largest element in the array is: " + largestElementRecursiveApproach(array));
    }

    /*
    Time Complexity: O(N)

Space Complexity: O(1)
     */
    private static int largestElementRecursiveApproach(int[] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    /*
    Time Complexity: O(N*log(N))

Space Complexity: O(n)
     */
    private static int largestElementByBruteForce(int[] array) {
        Arrays.sort(array);
        return array[array.length - 1];
    }

}
