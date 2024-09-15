package com.ace.array.medium;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println("abcdefghij".substring(3));
        int[] array = {2, 11, 15, 7};
        int target = 9;
        int[] result = twoSumBruteForce(array, target);
        System.out.println("Indices are: " + result[0] + " " + result[1]);
        result = twoSumBetterApproach(array, target);
        System.out.println("Indices are: " + result[0] + " " + result[1]);
        result = twoSumBestApproach(array, target);
        System.out.println("Indices are: " + result[0] + " " + result[1]);
    }

    private static int[] twoSumBestApproach(int[] array, int target) {//two pointer approach
        //Arrays.sort(array);
        int left=0, right=array.length-1;
        while (left<right){
            int sum = array[left]+array[right];
            if(target == sum){
                return new int[]{left, right};
            } else if(sum < target){
                left++;
            } else {
                right--;

            }
        }
        return new int[]{-1, -1};
    }

    private static int[] twoSumBetterApproach(int[] array, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<array.length; i++){
            int num = array[i];
            if(map.containsKey(target-num)){
                return new int[]{map.get(target-num), i};
            } else {
                map.put(num, i);
            }
        }
        return new int[]{-1, -1};
    }

    private static int[] twoSumBruteForce(int[] array, int target) {
        int[] result = new int[2];
        result[0] = result[1] = -1;
        for(int i=0; i<array.length; i++){
            for(int j=i+1; j<array.length; j++){
                if(array[i]+array[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}
