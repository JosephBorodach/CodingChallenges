package src.main.leatcode.easy;

public class palindrome {
    /**
     * Fastests solution I can think of is split the int,
     * Loop comparing each end
     * Return False if at any point they are not equal
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }

        String full = String.valueOf(x);
        String first = full.substring(0, full.length()/2);
        String second;
        //Check if it an odd length of even
        if ((full.length() % 2) == 0) {
            second = full.substring(full.length()/2, full.length());
        } else {
            second = full.substring(full.length()/2 + 1, full.length());
        }

        // Reverse the second string
        second = new StringBuilder(second).reverse().toString();

        Integer secondInt = Integer.parseInt(second);

        if (secondInt == 0) {
            return false;
        }
        if (Integer.parseInt(first) / secondInt == 1) {
            return true;
        }

        return false;
    }
}
