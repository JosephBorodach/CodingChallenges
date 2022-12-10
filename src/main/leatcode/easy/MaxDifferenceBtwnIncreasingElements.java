package src.main.leatcode.easy;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class MaxDifferenceBtwnIncreasingElements {

    /*
     * Complete the 'maxTrailing' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     *
     * Solution #1:
     * It appears arbitrary what the values are in the list
     * As you iterate over the list, constantly update the smallest value
     * Check if the largest value since the smallest value is greater than the original greatest difference
     * Run time is O(N) and memory is solid
     */
    public int maximumDifference(int[] nums) {
        if (nums.length < 2) {
            return -1;
        }
        int maxDiff = -1;
        int minNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < minNum) {
                minNum = nums[i];
            }
            else if ((nums[i] - minNum) > maxDiff) {
                maxDiff = (nums[i] - minNum);
            }
        }
        return maxDiff != 0 ? maxDiff : -1;
    }
}
