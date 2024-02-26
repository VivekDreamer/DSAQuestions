package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://www.geeksforgeeks.org/problems/power-set4302/1
public class POTD_PowerSet {
    public List<String> AllPossibleStrings(String s){
        List<String> ans = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        help(s,0,ans,temp);
        Collections.sort(ans);
        return ans;
    }
    void help(String s, int index, List<String> ans, StringBuilder temp){
        if(index == s.length()){
            if(temp.length() != 0) ans.add(temp.toString());
            return;
        }
        help(s, index+1, ans, temp);
        temp.append(s.charAt(index));
        help(s, index+1, ans, temp);
        temp.deleteCharAt(temp.length()-1);
    }
}
