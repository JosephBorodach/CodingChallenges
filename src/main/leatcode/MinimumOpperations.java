package src.main.leatcode;

import java.util.List;


public class MinimumOpperations {
    /*
     * Complete the 'minOperations' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static int minOperations(List<Integer> arr) {
        int LHL = run(arr, false);
        int HLH = run(arr, true);
        return LHL < HLH ? LHL : HLH;
    }

    private static int run (List<Integer> arr, boolean bool) {
        int size = arr.size();
        int val = 0;
        int i = 1;
        boolean greater = bool;
        int prev = arr.get(0);
        int cur;
        while (i < size) {
            cur = arr.get(i);
            if (greater) {
                if (prev >= cur) {
                    prev = i + 1 != size ? arr.get(i + 1) : cur;
                    val++;
                    i += 2;
                } else {
                    greater = false;
                    prev = cur;
                    i++;
                }
            } else {
                if (prev <= cur) {
                    prev = i + 1 != size ? arr.get(i + 1) : cur;
                    val++;
                    i += 2;
                } else {
                    greater = true;
                    prev = cur;
                    i++;
                }
            }
        }
        return val;
    }
}
