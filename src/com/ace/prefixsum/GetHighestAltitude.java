package com.ace.prefixsum;

import java.util.Arrays;

/*There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes.
The biker starts his trip on point 0 with altitude equal 0.
You are given an integer array gain of length n where gain[i] is the net gain in altitude between
points i and i + 1 for all (0 <= i < n). Return the highest altitude of a point.

Example 1:

Input: gain = [-5,1,5,0,-7]
Output: 1
Explanation: The altitudes are [0,-5,-4,1,1,-6]. The highest is 1.
Example 2:

Input: gain = [-4,-3,-2,-1,4,3,2]
Output: 0
Explanation: The altitudes are [0,-4,-7,-9,-10,-6,-3,-1]. The highest is 0.*/
public class GetHighestAltitude {
    public static void main(String[] args) {

        int[] gain = {-5, 1, 5, 0, -7};
        System.out.println("The highest altitude is: " + findHighestAltitude(gain));  // Output: 1

        int[] gain2 = {-4, -3, -2, -1, 4, 3, 2};
        System.out.println("The highest altitude with better way is: " + findHighestAltitudeBetterWay(gain2));  // Output: 0
        
//        int[] gainArr = {-5,1,5,0,-7};
//        int tempArr[] = new int[gainArr.length+1];
//        tempArr[0] = 0;
//        for (int i = 0; i < gainArr.length; i++) {
//            tempArr[i+1] = tempArr[i]+gainArr[i];
//        }
//        Arrays.stream(tempArr).forEach(i-> System.out.print(i+" "));
//        System.out.println("\n"+Arrays.stream(tempArr).max().getAsInt());
    }

    /*
    * Extra Space: This approach uses additional space to store the cumulative sum array, which is O(n) in terms of space complexity.
    * The findHighestAltitudeBetterWay approach provided  does not require this additional array and has O(1) space complexity
    * */
    private static int findHighestAltitude(int[] gainArr) {
        int tempArr[] = new int[gainArr.length+1];
        tempArr[0] = 0;
        for (int i = 0; i < gainArr.length; i++) {
            tempArr[i+1] = tempArr[i]+gainArr[i];
        }
        Arrays.stream(tempArr).forEach(i-> System.out.print(i+" "));
        return Arrays.stream(tempArr).max().getAsInt();
    }

    private static int findHighestAltitudeBetterWay(int[] gainArr) {
        int currentAltitude = 0;
        int maxAltitude = 0;

        for(int change: gainArr){
            currentAltitude+=change;
            if(currentAltitude>maxAltitude){
                maxAltitude = currentAltitude;
            }
        }
        return maxAltitude;
    }

}
