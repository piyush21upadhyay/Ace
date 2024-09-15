package com.ace.array.easy;

public class RotateByKElements {
    public static void main(String[] args) {
        int[] numsRight = {1, 2, 3, 4, 5, 6, 7};
        int kRight = 3;
        System.out.print("Right Rotation: ");
        rotateRight(numsRight, kRight);
        for (int num : numsRight) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] numsLeft = {1, 2, 3, 4, 5, 6, 7};
        int kLeft = 3;
        System.out.print("Left Rotation: ");
        rotateLeft(numsLeft, kLeft);
        for (int num : numsLeft) {
            System.out.print(num + " ");
        }
    }

    // Method to rotate array to the right by k steps
    /*Reverse the first part of the array (from start to k-1).
Reverse the second part of the array (from k to end).
Reverse the entire array.

    */
    public static void rotateRight(int[] nums, int k) {

        int n = nums.length;
        k = k % n;  // In case the rotating factor is greater than array length
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    // Method to rotate array to the left by k steps

    /**
     * Reverse the entire array.
     * Reverse the first n - k elements.
     * Reverse the remaining k elements.
     *
     * @param nums
     * @param k
     */
    public static void rotateLeft(int[] nums, int k) {
        int n = nums.length;
        k = k % n;  // In case the rotating factor is greater than array length
        reverse(nums, 0, n - 1);
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
