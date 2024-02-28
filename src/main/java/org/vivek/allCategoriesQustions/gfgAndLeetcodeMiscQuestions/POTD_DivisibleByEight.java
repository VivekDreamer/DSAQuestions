package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

// https://www.geeksforgeeks.org/problems/check-if-a-number-is-divisible-by-83957/1
public class POTD_DivisibleByEight {
    int DivisibleByEight(String s){
        if(s.length() <= 2) {
            int num = Integer.parseInt(s);
            return num % 8 == 0 ? 1 : -1;
        }
        String str = s.substring(s.length()-3);
        int num = Integer.parseInt(str);
        return num % 8 == 0 ? 1 : -1;
    }
}
