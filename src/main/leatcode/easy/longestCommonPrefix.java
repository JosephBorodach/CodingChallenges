package src.main.leatcode.easy;

import java.util.*;

public class longestCommonPrefix {
    /**
     * Could use a map but the lookup time probably wouldn't be great
     * If the array could be sorted, then you could use the shortest one first and check all of the other following it
     */
    public String solution(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        Arrays.sort(strs, new comp());
        //Arrays.sort(strs);
        //System.out.println(strs[0]);
        for (int i = strs[0].length(); i >= 0; i--) {
            Boolean failed = false;
            String prefix = strs[0].substring(0, i);
            Integer j = 1;
            while (!failed && j < strs.length) {
                if (strs[j].startsWith(prefix)) {
                    j++;
                } else {
                    failed = true;
                }
                if (!failed && j == strs.length) {
                    return prefix;
                }
            }
        }

        return "";
    }

    public class comp implements Comparator<String> {
        public int compare(String o1, String o2) {
            return Integer.compare(o1.length(), o2.length());
        }
    }
}
