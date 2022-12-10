package src.main.leatcode.hard;

import java.util.*;

public class SecureTheServers {
    public static long findLargestMinVulnerability(List<Integer> arr, long k) {
        if (k == 0) {
            return Collections.min(arr);
        }
        if (arr.size() == 1) {
            return arr.get(0) - k;
        }

        long smallest = Long.MAX_VALUE;
        long count = 0;

        for (int i = 0; i < arr.size(); i++, count++) {
            if (arr.get(i) < smallest) {
                smallest = arr.get(i) - 1;
            }
            arr.set(i, arr.get(i)-1);
        }

        // even them all out
        for (int i = arr.size() - 1; i >= 0 && count < k; i--) {
            if (arr.get(i) > smallest) {
                count += arr.get(i) - smallest;
            }
            arr.set(i, (int) smallest);
        }

        if (count < k) {
            if (((k - count) % arr.size()) == 0) {
                smallest -= (((k - count) / arr.size()));
            } else {
                smallest -= (((k - count) / arr.size()) + 1);
            }
        }
        return smallest;
    }
}
