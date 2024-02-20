package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

import java.util.ArrayList;
import java.util.HashSet;

// https://www.geeksforgeeks.org/problems/word-break1352/1
public class POTD_WordBreak {
    public static int wordBreak(int n, String s, ArrayList<String> dictionary){
        HashSet<String> hs = new HashSet<>(dictionary);
        return wordBreakUtil(s, hs) ? 1 : 0;
    }

    private static boolean wordBreakUtil(String s, HashSet<String> hs) {
        if(s == null || s == "" || hs.contains(s)) return true;
        for(int i = 1; i < s.length(); i++){
            String part1 = s.substring(0, i);
            String part2 = s.substring(i);
            if(hs.contains(part1) && wordBreakUtil(part2, hs)) return true;
        }
        return false;
    }
}
