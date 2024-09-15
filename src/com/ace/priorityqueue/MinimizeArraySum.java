package com.ace.priorityqueue;

import java.util.Collections;
import java.util.PriorityQueue;

/*
Given an array of integers, perform some number k of operations. Each operation
consists of removing an element from the array, dividing it by 2 and inserting the
ceiling of that result back into the array. Minimize the sum of the elements in the final array.

Example:
nums = [10, 20, 7]
k = 4

Pick  Pick/2  Ceiling  Result
Initial array [10, 20, 7]
7   3.5   4  [ 10, 20, 4]
10  5    5   [5, 20, 4]
20  10   10  [5, 10, 4]
10  5    5   [5, 5, 4]

The sum of the final array is 5 + 5 + 4 = 14, and that sum is minimal.
* **/
public class MinimizeArraySum {
    public static void main(String[] args) {
        int[] arr = {10, 20, 7};
        int k =4;
        System.out.println(minimizeArraySum(arr, k));
    }

    private static int minimizeArraySum(int[] arr, int k) {
        // Create a max-heap using a priority queue
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add all elements of the array to the max-heap
        for (int num : arr) {
            maxHeap.add(num);
        }

        // Perform k operations
        for (int i = 0; i < k; i++) {
            // Extract the largest element
            int largest = maxHeap.poll();
            // Divide by 2 and take the ceiling of the result
            int newElement = (int) Math.ceil(largest / 2.0);
            // Insert the new element back into the heap
            maxHeap.add(newElement);
        }
        // Calculate the sum of the elements in the heap
        int sum=0;
        while (!maxHeap.isEmpty()){
            sum+=maxHeap.poll();
        }
        return sum;
    }
}
