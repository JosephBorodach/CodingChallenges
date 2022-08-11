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
 *
 * Solutions:
 * 1) I went with the least clean solution, however it was not slower
 * 2) Use arrays - this would have been just as quick as if statements
 * 3) Using a Map seemed unecessarily slow
 */
public class RomanNumerals {
    public static String intToRoman(int num) {
        // It seems like there are 2 different scenarious
        // 1) Even numbers, where there is no subtraction
        // 2) Odd numbers, where there is subtraction
        // Deal with each value seperateley
        // Rememeber - substring goes until the end index, but does not include it
        String returnString = "";
        String strNum = String.valueOf(num);
        Integer strLength = strNum.length();
        if (strLength >= 4) {
            returnString += thousands(strNum);
            strNum = strNum.substring(1, 4);
        }
        if (strLength >= 3) {
            returnString += hundreds(strNum);
            strNum = strNum.substring(1, 3);
        }
        if (strLength >= 2) {
            returnString += tens(strNum);
            strNum = strNum.substring(1, 2);
        }
        if (strLength >= 1) {
            returnString += ones(strNum);
        }
        return returnString;
    }

    private static String thousands(String strNum) {
        String n = String.valueOf(strNum.charAt(0));
        if (n.equals("3")) {
            return "MMM";
        } else if (n.equals("2")) {
            return "MM";
        } else if (n.equals("1")) {
            return "M";
        }
        return "";
    }

    private static String hundreds(String strNum) {
        String n = String.valueOf(strNum.charAt(0));
        if (n.equals("9")) {
            return "CM";
        } else if (n.equals("8")) {
            return "DCCC";
        } else if (n.equals("7")) {
            return "DCC";
        } else if (n.equals("6")) {
            return "DC";
        } else if (n.equals("5")) {
            return "D";
        } else if (n.equals("4")) {
            return "CD";
        } else if (n.equals("3")) {
            return "CCC";
        } else if (n.equals("2")) {
            return "CC";
        } else if (n.equals("1")) {
            return "C";
        }
        return "";
    }

    private static String tens(String strNum) {
        String n = String.valueOf(strNum.charAt(0));
        if (n.equals("9")) {
            return "XC";
        } else if (n.equals("8")) {
            return "LXXX";
        } else if (n.equals("7")) {
            return "LXX";
        } else if (n.equals("6")) {
            return "LX";
        } else if (n.equals("5")) {
            return "L";
        } else if (n.equals("4")) {
            return "XL";
        } else if (n.equals("3")) {
            return "XXX";
        } else if (n.equals("2")) {
            return "XX";
        } else if (n.equals("1")) {
            return "X";
        }
        return "";
    }

    private static String ones(String strNum) {
        String n = String.valueOf(strNum.charAt(0));
        if (n.equals("9")) {
            return "IX";
        } else if (n.equals("8")) {
            return "VIII";
        } else if (n.equals("7")) {
            return "VII";
        } else if (n.equals("6")) {
            return "VI";
        } else if (n.equals("5")) {
            return "V";
        } else if (n.equals("4")) {
            return "IV";
        } else if (n.equals("3")) {
            return "III";
        } else if (n.equals("2")) {
            return "II";
        } else if (n.equals("1")) {
            return "I";
        }
        return "";
    }

    public static void main(String args[]) {
        //prints roman numerals from 1 to 200
        for (int i = 1;i<256;i++) {
            System.out.println("i="+i+" -> "+ intToRoman(i));
        }
    }
}
