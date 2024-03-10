package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

import java.util.LinkedHashSet;
import java.util.Set;

// https://www.geeksforgeeks.org/problems/remove-all-duplicates-from-a-given-string4321/1
public class POTD_RemoveAllDuplicatesFromString {
    String removeDuplicates(String str) {
        Set<Character> set = new LinkedHashSet<>();
        for(char ch : str.toCharArray()){
            set.add(ch);
        }
        String res = "";
        for(char ch : set){
            res += ch;
        }
        return res;
    }
}
