package src.main.leatcode.easy;

import java.util.*;

public class MexGame {
    /*
     * Complete the 'getMaximumMEX' function below.
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     *
     */
    public static int getMaximumMEX(List<Integer> arr) {
        Collections.sort(arr);
        int mex = 0;
        int counter = 0;
        Set<Integer> s = new HashSet<>();
        for (Integer cur : arr) {
            // if already contains that value, skip - doesn't matter what their relaitonship is
            if (!s.contains(cur)) {
                // current value is greater than or equal to the counter
                if (cur >= counter) {
                    mex++;
                    s.add(counter++);
                } else {
                    counter = cur;
                }
            }
        }
        return mex;
    }
}
