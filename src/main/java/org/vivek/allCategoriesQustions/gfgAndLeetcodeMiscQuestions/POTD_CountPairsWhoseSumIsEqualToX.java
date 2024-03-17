package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

import java.util.HashSet;
import java.util.LinkedList;

// https://www.geeksforgeeks.org/problems/count-pairs-whose-sum-is-equal-to-x/1
public class POTD_CountPairsWhoseSumIsEqualToX {
    public static int countPairs(LinkedList<Integer> head1, LinkedList<Integer> head2,
                          int x) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : head1){
            set.add(i);
        }
        int count = 0;
        for(int j : head2){
            if(set.contains(x-j)) count++;
        }
        return count;
    }
}
