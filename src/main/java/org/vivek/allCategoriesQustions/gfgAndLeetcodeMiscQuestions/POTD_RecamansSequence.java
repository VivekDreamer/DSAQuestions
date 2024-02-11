package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// https://www.geeksforgeeks.org/problems/recamans-sequence4856/1
public class POTD_RecamansSequence {
    static ArrayList<Integer> recamanSequence(int n){
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(0);
        if(n == 0) {
            return ans;
        }
        Set<Integer> ansSet = new HashSet<>();
        for(int i=1; i<n; i++) {
            int val = ans.get(i-1) - i;
            if(!(val > 0 && !ansSet.contains(val))) {
                val = ans.get(i-1) + i;
            }
            ansSet.add(val);
            ans.add(val);
        }
        return ans;
    }
}
