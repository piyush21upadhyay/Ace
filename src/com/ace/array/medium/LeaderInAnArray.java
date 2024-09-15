package com.ace.array.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an array, print all the elements which are leaders.
 * A Leader is an element that is greater than all of the elements on its right side in the array.
 *
 * Example 1:
 * Input: *
 *  arr = [4, 7, 1, 0]
 * Output
 *  7 1 0
 * Explanation:
 *  Rightmost element is always a leader. 7 and 1 are greater than the elements in their right side.
 *
 * Example 2:
 * Input:
 *  arr = [10, 22, 12, 3, 0, 6]
 * Output:
 *  22 12 6
 * Explanation:
 *  6 is a leader. In addition to that, 12 is greater than all the elements in its right side (3, 0, 6), also 22 is greater than 12, 3, 0, 6.
 * ***/
public class LeaderInAnArray {
    public static void main(String[] args) {
        int arr[]=  {10, 22, 12, 3, 0, 6};
        List<Integer> ans= printLeadersUsingBruteForce(arr);
        ans.stream().forEach(a-> System.out.print(a+" "));
        System.out.println("\nUsing optimal Approach");
        List<Integer> ans1= printLeadersUsingOptimalApproach(arr);
        Collections.sort(ans1, Collections.reverseOrder());
        ans1.stream().forEach(a-> System.out.print(a+" "));

    }

    private static List<Integer> printLeadersUsingOptimalApproach(int[] arr) {
        List<Integer> list = new ArrayList<>();
        list.add(arr[arr.length-1] );
        int max = arr[arr.length-1];
        // Start checking from the end whether a number is greater
        // than max no. from right, hence leader.
        for(int i= arr.length-2; i>=0; i--){
            if(arr[i]>max){
                list.add(arr[i]);
                max = arr[i];

            }
        }
        return list;
    }

    private static List<Integer> printLeadersUsingBruteForce(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i< arr.length; i++){
            boolean leader = true;
            for(int j = i+1; j<arr.length; j++){
                if(arr[j]>arr[i]){
                    leader = false;
                    break;
                }
            }
            if(leader)
                list.add(arr[i]);
        }
        return list;
    }
}
