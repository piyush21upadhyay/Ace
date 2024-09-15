package com.ace.hashmaporset;

import java.util.*;
import java.util.stream.Collectors;

/*Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:

answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
Note that the integers in the lists may be returned in any order.

Example 1:

Input: nums1 = [1,2,3], nums2 = [2,4,6]
Output: [[1,3],[4,6]]
Explanation:
        For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
        For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums2. Therefore, answer[1] = [4,6].
*/
public class ArrayDifference {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,4,6};

        //findDifferencePiyushWay(nums1,nums2);
        List<Integer> difference = findDifferenceBestWay(nums1,nums2);
        System.out.println("Difference: " + difference);

        List<Integer> difference2 = findDifferenceBestWay(nums2,nums1);
        System.out.println("Difference: " + difference2);

        List<List<Integer>> finalList = new ArrayList<>();
        finalList.add(difference);
        finalList.add(difference2);
        System.out.println("Result: "+ finalList);
    }

    private static List<Integer> findDifferenceBestWay(int[] nums1, int[] nums2) {
        // Convert the second array to a HashSet for fast lookup
        Set<Integer> set = new HashSet<>();
        for (int i: nums2){
            set.add(i);
        }

        // Create a list to store the difference
        List<Integer> difference = new ArrayList<>();
        for (int num: nums1){
            if(!set.contains(num)){
                difference.add(num);
            }
        }
        return difference;
    }

    private static void findDifferencePiyushWay(int[] nums1, int[] nums2) {
        List<Integer> list1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());

        for(Integer n : list1){
            if (!list2.contains(n)){
                System.out.print(n);
            }
        }
        System.out.println("\n");
        for(Integer n : list2){
            if (!list1.contains(n)){
                System.out.print(n);
            }
        }
    }
}
