package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

import java.util.HashSet;
import java.util.Set;

// https://www.geeksforgeeks.org/problems/count-pairs-sum-in-matrices4332/1
public class POTD_CountPairSumInMatrices {
    int countPairs(int mat1[][], int mat2[][], int n, int x) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                set.add(mat1[i][j]);
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(set.contains(x - mat2[i][j])) count++;
            }
        }
        return count;
    }
}
