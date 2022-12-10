package src.main.leatcode.arrays.easy;

import java.util.*;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 */
public class ContainsDuplicate {
    /**
     * Time complexity: O(n log n). Sorting is O(n log n) and the sweeping is O(n). The entire algorithm is dominated by the sorting step, which is O(n log n).
     * Space complexity: O(1). Space depends on the sorting implementation which, usually, costs O(1) auxiliary space if heapsort is used.
     */
    public boolean Sorting(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        if (nums.length == 2) {
            return nums[0] == nums[1];
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Winner!
     * Time complexity: O(n). We do search() and insert() for n times and each operation takes constant time.
     * Space complexity: O(n). The space used by a hash table is linear with the number of elements in it.
     */
    public boolean HashTable(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}