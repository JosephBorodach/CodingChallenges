package src.main.leatcode.arrays.easy;

import java.util.*;

public class ValidAnagram {

    /**
     * Winner!
     * Time complexity: O(n). Time complexity is O(n) because accessing the counter table is a constant time operation.
     * Space complexity: O(1). Although we do use extra space, the space complexity is O(1) because the table's size stays constant no matter how large
     * @param s
     * @param t
     * @return
     */
    public boolean FrequencyCounter(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Time complexity: O(n log n). Assume that n is the length of s, sorting costs O(n log n) and comparing two strings costs O(n). Sorting time dominates and the overall time complexity is O(n log n).
     * Space complexity: O(1). Space depends on the sorting implementation which, usually, costs O(1) auxiliary space if heapsort is used. Note that in Java, toCharArray() makes a copy of the string so it costs O(n) extra space, but we ignore this for complexity analysis because:
        * It is a language dependent detail.
        * It depends on how the function is designed. For example, the function parameter types can be changed to char[].
     */
    public boolean Sorting(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] first = s.toCharArray();
        char[] sec = t.toCharArray();
        Arrays.sort(first);
        Arrays.sort(sec);
        return Arrays.equals(first, sec);
    }

    public boolean HashMap(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // decrement the map
        int count = 0;
        for (Character c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }
            count = map.get(c);
            if (count <= 0) {
                return false;
            }
            map.put(c, count-1);
        }
        return true;
    }

}
