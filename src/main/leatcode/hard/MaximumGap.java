package src.main.leatcode.hard;

import java.util.Arrays;

public class MaximumGap {
    /**
     * LeetCode 164: Maximum Gap (Hard)
     * Given an integer array nums, return the maximum difference between two successive elements in its sorted form. If the array contains less than two elements, return 0.
     * Sort the array - Use Arrays.sort($array$)
     * Then calculate the difference between each consecutive numbers
     * Check if it's greater than the current max number
     */
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        Integer curMax = 0;
        Integer diff = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            diff = nums[i+1] - nums[i];
            if (diff > curMax) {
                curMax = diff;
            }
        }
        return curMax;
    }
}
