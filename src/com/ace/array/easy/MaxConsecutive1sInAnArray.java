package com.ace.array.easy;

public class MaxConsecutive1sInAnArray {
    public static void main(String[] args) {
        int nums[] = {1,0,1,1,0,1,1,1,0};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    private static int findMaxConsecutiveOnes(int[] nums) {
        int cnt=0,max=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1){
                cnt++;
            }else{
                cnt=0;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}
