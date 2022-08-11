package src.main.leatcode;

import static java.util.Map.entry;

import java.util.HashMap;
import java.util.Map;

public class IntegerToWords {
    /**
     * Think of potential solutions - all #s leading with a digit will begin with that digit, i.e. 100, One Hundred - 1000 - One thousand
     * Numbers are divided into sections of three, 111,111 - One Hundred Eleven Thousand One Hundred Eleven
     * Accordingly, create an array of numbers that matches and array of their English equivalent.
     * Then, create a seperate array that repsents that matches another array for the English equivalent descriptive placeholder, i.e. 100 - Hundred, 1,000,000 - Million, etc.
     */

    /**
     * DS I chose - I chose to use a Map for the numbers themselves because there are so many and I wasn't sure that using an array would be quicker
     * This was not my best work
     * Things to improve on - 1) More sudo code, 2) Sub divide the different pieces of responsibility into sub methods, 3) Use class variables
     */
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        if (num == 10) {
            return "Ten";
        }
        /**
         * Without importing there is no quicker way to do this
         */
        Map<Integer, String> numbers = new HashMap<>() {{
            put(1, "One");
            put(2, "Two");
            put(3, "Three");
            put(4, "Four");
            put(5, "Five");
            put(6, "Six");
            put(7, "Seven");
            put(8, "Eight");
            put(9, "Nine");
            put(10, "Ten");
            put(11,"Eleven");
            put(12,"Twelve");
            put(13,"Thirteen");
            put(14,"Fourteen");
            put(15,"Fifteen");
            put(16,"Sixteen");
            put(17,"Seventeen");
            put(18,"Eighteen");
            put(19,"Nineteen");
            put(20,"Twenty");
            put(30,"Thirty");
            put(40,"Forty");
            put(50,"Fifty");
            put(60,"Sixty");
            put(70,"Seventy");
            put(80,"Eighty");
            put(90,"Ninety");
        }};
        String strNum = String.valueOf(num);
        String strRemaining = strNum;
        String returnString = "";

        while (strRemaining.length() != 0) {
            String strCurrent = strRemaining;
            Integer strLength = strRemaining.length();

            // If the string is > 999, then trim it
            Integer remainder = strLength % 3;
            Integer index;
            if (remainder == 0) {
                index = 3;
            } else {
                index = remainder;
            }

            strCurrent = strRemaining.substring(0, index);
            if (strLength > 3) {
                strRemaining = strRemaining.substring(index, strLength);
            } else {
                strRemaining = "";
                strLength = 0;

            }

            String subString = strCurrent;
            Integer subValue = Integer.valueOf(subString);
            Integer currentLength = strCurrent.length();
            while (currentLength != 0) {
                Integer currentVal = Integer.valueOf(strCurrent.substring(0, 1));

                // Shorten the string - The current length works because a substring only goes up until the index, but not including it
                String original = strCurrent;
                strCurrent = currentLength > 1 ? strCurrent.substring(1, currentLength) : "";

                System.out.println("HERE " + strCurrent);

                // Base case - Skip zeros
                if (currentVal != 0) {
                    // Get & add the word equivalent
                    if (currentLength == 2) {
                        Integer twoDigits = Integer.valueOf(original.substring(0, 2));
                        // Case #1: 15
                        // Case #2: 25
                        // Case #3: 20
                        if (twoDigits < 20) {
                            returnString += numbers.get(twoDigits);
                            --currentLength;
                            strCurrent = currentLength > 1 ? strCurrent.substring(1, currentLength) : "";
                            //i.e. 41
                        } else {
                            returnString += numbers.get(currentVal * 10);
                        }
                    } else {
                        // Single digit remaning
                        returnString += numbers.get(currentVal);
                    }

                    if (addSpace(strCurrent) || addSpace(strRemaining) || currentLength == 3) {
                        returnString += " ";
                    }

                    // Get & add the word description
                    // if there is at least 3 digits remaning and the first is != 0, i.e. 100 || 990
                    System.out.println("HERE: " + currentLength + " - " + strCurrent);

                    if (currentLength == 3 && currentVal > 0) { // nonZero(subString)
                        returnString += placeDescription(currentLength);
                        if (addSpace(strCurrent) || addSpace(strRemaining) || (currentLength == 3 && strRemaining.length() >= 3)) {
                            returnString += " ";
                        }
                    }
                }
                --currentLength;
            }

            // Warrent subsection description?
            // One # followed by only 0s
            if (strRemaining.length() >= 3) {
                if (num > 99 && num % 10 == 0 && onlyZeros(strNum.substring(1, strNum.length()))) {
                    returnString += placeDescription(strLength);
                    break;
                } else if (subValue > 0) {
                    returnString += placeDescription(strLength);
                    if (descriptionAddSpace(strRemaining)) {
                        returnString += " ";
                    }
                    /*
                    if (shouldBreak(strRemaining)) {
                        break;
                    }
                    */
                }
            }
        }

        return returnString;
    }

    private Boolean nonZero(String s) {
        Integer n = Integer.valueOf(s);
        if (n != 0) {
            return true;
        }
        return false;
    }

    private Boolean onlyZeros(String s) {
        Integer n = Integer.valueOf(s);
        if (n != 0) {
            return false;
        }
        return true;
    }


    private Boolean nonZeros(String s) {
        Integer l = s.length();
        if (l > 0) {
            Integer nonZeros = Integer.valueOf(s.substring(0, l));
            if (nonZeros != 0) {
                return true;
            }
        }
        return false;
    }

    private Boolean shouldBreak(String s) {
        Integer l = s.length();
        if (l > 0) {
            Integer nonZeros = Integer.valueOf(s.substring(0, l));
            if (nonZeros == 0) {
                return true;
            }
        }
        return false;
    }

    private Boolean descriptionAddSpace(String s) {
        Integer l = s.length();
        if (l > 0) {
            Integer nonZeros = Integer.valueOf(s.substring(0, l));
            if (nonZeros > 0) {
                return true;
            }
        }
        return false;
    }

    private Boolean addSpace(String s) {
        Integer l = s.length();
        if (l > 0) {
            Integer nonZeros = Integer.valueOf(s.substring(0, l));
            if (nonZeros > 0 || l >= 3) {
                return true;
            }
        }
        return false;
    }

    private String placeDescription(Integer length) {
        if (length > 12) {
            return "Trillion";
        } else if (length > 9) {
            return "Billion";
        } else if (length > 6) {
            return "Million";
        } else if (length > 3) {
            return "Thousand";
        }
        return "Hundred";
    }

/*
1234567891
1000010
14
12345
1000000
10
100
101
1100
    */


}
