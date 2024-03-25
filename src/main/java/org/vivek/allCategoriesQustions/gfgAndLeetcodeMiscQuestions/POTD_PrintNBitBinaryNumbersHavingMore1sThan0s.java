package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

import java.util.ArrayList;
import java.util.Collections;

// https://www.geeksforgeeks.org/problems/print-n-bit-binary-numbers-having-more-1s-than-0s0252/1
public class POTD_PrintNBitBinaryNumbersHavingMore1sThan0s {
    ArrayList<String> NBitBinary(int N) {
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        temp.append("1");
        help(ans, 0, 1, temp, N);
        Collections.sort(ans);
        Collections.reverse(ans);
        return ans;
    }
    void help(ArrayList<String> ans, int zero, int one, StringBuilder temp, int n){
        if(temp.length() == n){
            ans.add(temp.toString());
            return;
        }
        if(one > zero){
            temp.append('0');
            help(ans, zero+1, one, temp, n);
            temp.deleteCharAt(temp.length()-1);
        }
        temp.append('1');
        help(ans, zero, one+1, temp, n);
        temp.deleteCharAt(temp.length()-1);
    }
}
