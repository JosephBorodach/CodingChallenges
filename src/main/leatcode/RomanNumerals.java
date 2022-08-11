package src.main.leatcode;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral.
 */
public class RomanNumerals {
    public String intToRoman(int num) {
        // It seems like there are 2 different scenarious
        // 1) Even numbers, where there is no subtraction
        // 2) Odd numbers, where there is subtraction
        // Deal with each value seperateley
        String returnString = "";
        String strNum = String.valueOf(num);
        for (int i = 0; i < strNum.length(); i++) {
            if (i == 3) {
                returnString += thousands(strNum);
            } else if (i == 2) {
                returnString += hundreds(strNum);
            } else if (i == 1) {
                returnString += tens(strNum);
            } else {
                returnString += ones(strNum);
            }
        }
        return returnString;
    }

    private String thousands(String strNum) {
        String n = String.valueOf(strNum.charAt(3));
        if (n.equals("1")) {
            return "M";
        } else if (n.equals("2")) {
            return "MM";
        }
        return "MMM";
    }

    private String hundreds(String strNum) {
        String n = String.valueOf(strNum.charAt(2));
        if (n.equals("9")) {
            return "CM";
        } else if (n.equals("5")) {
            return "D";
        } else if (n.equals("4")) {
            return "CD";
        } else if (n.equals("3")) {
            return "CCC";
        } else if (n.equals("2")) {
            return "CC";
        }
        return "C";
    }

    private String tens(String strNum) {
        String n = String.valueOf(strNum.charAt(1));
        if (n.equals("9")) {
            return "XC";
        } else if (n.equals("5")) {
            return "V";
        } else if (n.equals("4")) {
            return "IV";
        } else if (n.equals("3")) {
            return "III";
        } else if (n.equals("2")) {
            return "II";
        }
        return "I";
    }

    private String ones(String strNum) {
        String n = String.valueOf(strNum.charAt(0));
        if (n.equals("5")) {
            return "V";
        } else if (n.equals("4")) {
            return "IV";
        } else if (n.equals("3")) {
            return "III";
        } else if (n.equals("2")) {
            return "II";
        }
        return "I";
    }
}
