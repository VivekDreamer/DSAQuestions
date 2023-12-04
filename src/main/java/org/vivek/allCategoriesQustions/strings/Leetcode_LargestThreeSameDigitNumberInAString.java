package org.vivek.allCategoriesQustions.strings;

// https://leetcode.com/problems/largest-3-same-digit-number-in-string/
public class Leetcode_LargestThreeSameDigitNumberInAString {
    public String largestGoodInteger(String num) {
        char maxChar = ' ';
        for (int i = 2; i < num.length(); i++) {
            if (num.charAt(i) == num.charAt(i - 1) && num.charAt(i) == num.charAt(i - 2)) {
                maxChar = (char) Math.max(maxChar, num.charAt(i));
            }
        }
        return maxChar == ' ' ? "" : new String(new char[] { maxChar, maxChar, maxChar });
    }
}
