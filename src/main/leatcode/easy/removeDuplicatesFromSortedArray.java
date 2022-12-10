package src.main.leatcode.easy;

public class removeDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        Integer j = 0;
        Integer i = 0;
        while (i < nums.length - 1) {
            if (nums[i] != nums[i+1]) {
                nums[j++] = nums[i];
            }
            i++;
        }
        nums[j++] = nums[nums.length - 1];
        return j;
    }
}
