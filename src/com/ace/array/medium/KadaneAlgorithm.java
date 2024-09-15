package com.ace.array.medium;

/*
Given an integer array arr, find the contiguous subarray (containing at least one number) which
has the largest sum and returns its sum and prints the subarray.
Example 1:
Input:
 arr = [-2,1,-3,4,-1,2,1,-5,4]

Output:
 6

Explanation:
 [4,-1,2,1] has the largest sum = 6.
/
 */
public class KadaneAlgorithm {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArraySumBruteForce(arr));
        System.out.println(maxSubArraySumoptimalApproach(arr));
    }

    private static int maxSubArraySumoptimalApproach(int[] arr) {
        int max = Integer.MIN_VALUE;
        int sum =0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
            if(sum>max){
                max=sum;
            }
            // If sum < 0: discard the sum calculated so far and start fresh from the next element
            if(sum<0){
                sum=0;
            }


        }
        return max;
    }

    private static int maxSubArraySumBruteForce(int[] arr) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i< n ; i++){
            int sum=0;
            for (int j=i; j< n; j++){
                sum+=arr[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}
