package com.zys.leetcode;

/**
 * 用来演示双指针算法
 *
 */
public class SortArrayDuplicates {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0,1,2,2,3,3,4}));
    }


    public static int removeDuplicates(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }
        int i = 0;//i为慢指针，j为快指针
        for (int j = 1; j < nums.length; j++){
            if (nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

}
