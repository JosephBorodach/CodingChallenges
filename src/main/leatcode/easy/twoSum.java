package src.main.leatcode.easy;

import java.util.*;

public class twoSum {
    /**
     * Iterate over the entire array
     * Iterate again over the array
     * Check if the 2 indexes are equal
     * If they are not equal, then check if they equal the target
     * if they do than return them
     */
    public int[] compute(int[] nums, int target) {
        int[] returnArray;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    if (nums[i] + nums[j] == target) {
                        returnArray = new int[]{i, j};
                        return returnArray;
                        //return new int[]{i, j};
                    }
                }
            }
        }
        returnArray = new int[2];
        return returnArray;
    }

    public int[] faster(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0; i < nums.length; i++){
            int cur = nums[i];
            int x = target - cur;
            if(map.containsKey(x)){
                return new int[] {map.get(x), i};
            }
            map.put(cur, i);
        }
        return null;
    }

}
