package com.zys.leetcode;

import java.util.Arrays;

/**
 * 寻找数组中心下标：该下标左边与右边的数据求和结果相等。
 *
 */
public class ArrayCenterIndex {

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1,7,3,6,5,6}));
    }

    public static int pivotIndex(int[] nums){
        int sum = Arrays.stream(nums).sum();
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            count += nums[i];
            if (count == sum){
                return i;
            }
            sum -= nums[i];
        }
        return -1;
    }

}
