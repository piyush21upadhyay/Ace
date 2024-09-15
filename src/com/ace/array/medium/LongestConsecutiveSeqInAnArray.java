package com.ace.array.medium;

import java.util.HashSet;
import java.util.Set;

/*
Problem Statement: You are given an array of ‘N’ integers.
You need to find the length of the longest sequence which contains the consecutive elements.

Example 1:
Input:
 [100, 200, 1, 3, 2, 4]
Output:
 4
Explanation:
 The longest consecutive subsequence is 1, 2, 3, and 4.

Input:
 [3, 8, 5, 7, 6]
Output:
 4
Explanation:
 The longest consecutive subsequence is 5, 6, 7, and 8.
* **/
public class LongestConsecutiveSeqInAnArray {
    public static void main(String[] args) {
        int a[] = {100, 200, 1, 3, 2, 4};
        int ans = longestConsecutiveUsingBruteForce(a);
        System.out.println(ans);
        System.out.println(longestConsecutiveUsingOptimalApproach(a));
    }

    private static int longestConsecutiveUsingOptimalApproach(int[] a) {
        int maxLength =1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);
        }

        // Find the longest sequence
        for(int i: set){
            if(!set.contains(i-1)){ // if 'i' is a starting number
                int lengthOfCurrSeq =1;
                int currElement = i;
                while (set.contains(currElement+1)){
                    currElement+=1;
                    lengthOfCurrSeq+=1;
                }
                maxLength = Math.max(maxLength, lengthOfCurrSeq);
            }
        }
        return maxLength;
    }

    private static int longestConsecutiveUsingBruteForce(int[] a) {
        int longest = 1;

        for (int i = 0; i < a.length; i++) {
            int currElement = a[i];
            int lengthOfCurrSeq = 1; //o store the length of the current sequence

            while (isNextElementPresent(a, currElement + 1)==true) {
                currElement += 1;
                lengthOfCurrSeq += 1;
            }
            longest = Math.max(longest, lengthOfCurrSeq);
        }

        return longest;
    }

    private static boolean isNextElementPresent(int[] a, int searchElement) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == searchElement) {
                return true;
            }
        }
        return false;
    }
}
