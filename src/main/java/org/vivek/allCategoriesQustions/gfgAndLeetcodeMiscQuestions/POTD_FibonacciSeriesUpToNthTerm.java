package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

public class POTD_FibonacciSeriesUpToNthTerm {
    int MOD = (int)(1e9)+7;
    int[] Series(int n) {
        int[] res = new int[n+1];
        res[0] = 0;
        res[1] = 1;
        for(int i = 2; i < res.length; i++){
            res[i] = (res[i-1]%MOD+res[i-2]%MOD)%MOD;
        }
        return res;
    }
}
