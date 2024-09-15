package com.ace.arraystrings;

/**
 * You have a long flowerbed in which some of the plots are planted, and some are not.
 * However, flowers cannot be planted in adjacent plots.
 *
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty
 * and 1 means not empty, and an integer n, return true if n new flowers can be planted
 * in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
 *
 *  Example 1:
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 *
 * Example 2:
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: false
 */
public class CanPlaceFlowers {
    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 1};
        int n = 1;
        System.out.println("Can place flowers: " + canPlaceFlowers(flowerbed, n));
    }

    private static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int length = flowerbed.length;

        // We can treat the problem as having two additional empty plots at the beginning and end
        int[] extendedFlowerbed = new int[length + 2];
        System.arraycopy(flowerbed, 0, extendedFlowerbed, 1, length);

        for (int i = 1; i <= length; i++) {
            if (extendedFlowerbed[i] == 0 && extendedFlowerbed[i - 1] == 0 && extendedFlowerbed[i + 1] == 0) {
                extendedFlowerbed[i] = 1;
                count++;

                if (count >= n) {
                    return true;
                }
            }
        }

        return count >= n;
    }
}
