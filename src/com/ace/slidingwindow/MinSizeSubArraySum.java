package com.ace.slidingwindow;

/*
* Given an array of positive integers nums and a positive integer target,
* return the minimal length of a subarray whose sum is greater than or equal to target.
*  If there is no such subarray, return 0 instead.
 * */
public class MinSizeSubArraySum {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(target, nums));  // Output: 2

        target = 15;
        nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(minSubArrayLen(target, nums));  // Output: 5

        target = 100;
        nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(minSubArrayLen(target, nums));  // Output: 0
    }

    private static int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int sum=0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum>=target){
                minLength = Math.min(minLength, right-left+1);
                sum -= nums[left++];
            }
        }
    return minLength == Integer.MAX_VALUE ? 0: minLength;
    }
}
