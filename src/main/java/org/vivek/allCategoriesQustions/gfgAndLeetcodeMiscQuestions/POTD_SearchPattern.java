package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

import java.util.ArrayList;
// https://www.geeksforgeeks.org/problems/search-pattern-rabin-karp-algorithm--141631/1
public class POTD_SearchPattern {
    ArrayList<Integer> search(String pattern, String text){
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<=text.length()-pattern.length(); i++){
            String a = text.substring(i,i+pattern.length());
            if(a.equals(pattern)){
                ans.add(i+1);
            }
        }
        return ans;
    }
}
