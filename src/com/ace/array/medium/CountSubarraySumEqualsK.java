package com.ace.array.medium;

import java.util.*;

/*Problem Statement: Given an array of integers and an integer k,
        return the total number of subarrays whose sum equals k.

Example 1:
Input Format:
N = 4, array[] = {3, 1, 2, 4}, k = 6
Result:
        2
Explanation:
The subarrays that sum up to 6 are [3, 1, 2] and [2, 4].*/
public class CountSubarraySumEqualsK {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        int k = 6;
        System.out.println(bruteForce(arr, k));
        System.out.println(better(arr, k));
        System.out.println(optimal(arr, k));
    }

    /*
    * Prefix Sum Approach
    * */
    private static int optimal(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        int preSum=0, cnt=0;
        map.put(0, 1); // Setting 0 in the map.
        for(int i=0; i< n; i++){
            preSum +=arr[i];

            int remove = preSum -k;
            cnt += map.getOrDefault(remove, 0); // Add the number of subarrays to be removed:

            map.put(preSum, map.getOrDefault(preSum, 0)+1); // Add the current prefix sum to the map.

        }
        return cnt;
    }

    private static int better(int[] arr, int k) {
        int n = arr.length;
        int cnt=0; // Number of subarrays:
        for (int i=0; i<n; i++){
            int sum =0;
            for (int j=i; j<n; j++){
                sum += arr[j];
                if(sum == k)
                    cnt++;

            }
        }
        return cnt;
    }

    private static int bruteForce(int[] arr, int k) {
        int n = arr.length; // size of the given array.
        int cnt = 0; // Number of subarrays:

        for (int i = 0 ; i < n; i++) { // starting index i
            for (int j = i; j < n; j++) { // ending index j

                // calculate the sum of subarray [i...j]
                int sum = 0;
                for (int K = i; K <= j; K++)
                    sum += arr[K];

                // Increase the count if sum == k:
                if (sum == k)
                    cnt++;
            }
        }
        return cnt;
    }
}
