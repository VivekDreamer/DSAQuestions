package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

import java.util.Arrays;

// https://www.geeksforgeeks.org/problems/distinct-occurrences/1
public class POTD_DistinctOccurrences {

    //recursion [TLE]
    /*
    public int subsequenceCount(String s, String t){
        return subsequenceCountUtil(s, t,0,0);
    }

    private int subsequenceCountUtil(String s, String t, int i, int j) {
        if(j == t.length()) return 1;
        if(i == s.length()) return 0;
        int a = 0, b = 0;
        if(s.charAt(i) == t.charAt(j)){
            a = subsequenceCountUtil(s, t, i+1, j+1);
        }
        b = subsequenceCountUtil(s, t, i+1, j);
        return a+b;
    }
     */

     //Memoization
     int MOD = 1000000007;
     public int subsequenceCount(String s, String t){
        int[][] memo = new int[s.length()+1][t.length()+1];
        for(int[] arr : memo){
            Arrays.fill(arr, -1);
        }
        return subsequenceCountUtil(s, t,0,0, memo);
    }

    private int subsequenceCountUtil(String s, String t, int i, int j, int[][] memo) {
        if(j == t.length()) return 1;
        if(i == s.length()) return 0;
        if(memo[i][j] != -1) return memo[i][j];
        int a = 0, b = 0;
        if(s.charAt(i) == t.charAt(j)){
            a = subsequenceCountUtil(s, t, i+1, j+1, memo);
        }
        b = subsequenceCountUtil(s, t, i+1, j, memo);
        return memo[i][j] = (a+b)%MOD;
    }
}
