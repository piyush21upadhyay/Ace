package com.ace.array.easy;

public class LongestSubstringWithGivenSum {
    public static void main(String[] args) {
        /*int k = 5;
        int array[] = {2,3,5};*/
        /*int k = 10;
        int array[] = {2,3,5,1,9};*/
        int k = 1;
        int array[] = {-1, 1, 1};
        System.out.println(longestSubstringWithGivenSum(array, k));
    }

    private static int longestSubstringWithGivenSum(int[] array, int k) {
        int longestSubstring = 0;
        int sum=0;
        int counter = 0;
        for (int i=0; i< array.length; i++){
            sum = sum + array[i];
            counter++;
            if(sum == k){
                longestSubstring = Math.max(longestSubstring, counter);
                counter=0;
            }
        }
        return longestSubstring;
    }
}
