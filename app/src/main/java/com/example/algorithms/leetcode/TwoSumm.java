package com.example.algorithms.leetcode;

public class TwoSumm {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = 1;
        while (nums[i] + nums[j] != target) {
            if (j == nums.length - 1) {
                i++;
                j = i + 1;
            } else {
                j++;
            }
        }
        return new int[]{i, j};
    }
}
