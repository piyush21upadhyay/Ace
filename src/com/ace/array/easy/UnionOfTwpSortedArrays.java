package com.ace.array.easy;

import java.util.ArrayList;
import java.util.HashMap;

public class UnionOfTwpSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4, 5, 7};
        int[] arr2 = {2, 3, 5, 6};
        int m = arr1.length;
        int n = arr2.length;
        printUnion(arr1, arr2, m, n);
    }

    private static void printUnion(int[] arr1, int[] arr2, int m, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> union = new ArrayList<>();

        for(int i=0; i< arr1.length; i++){
            map.put(arr1[i], map.getOrDefault(arr1[i], 0)+1);
        }

        for(int i=0; i< arr2.length; i++){
            map.put(arr2[i], map.getOrDefault(arr2[i], 0)+1);
        }

        for (int key: map.keySet())
            union.add(key);

        union.stream().forEach(k-> System.out.print(k+" "));
    }
}
