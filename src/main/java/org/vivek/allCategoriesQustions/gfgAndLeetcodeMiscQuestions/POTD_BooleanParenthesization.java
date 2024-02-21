package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

import java.util.Arrays;

// https://www.geeksforgeeks.org/problems/boolean-parenthesization5610/1
public class POTD_BooleanParenthesization {
    /* 
    public static int countWays(int n, String s){
        return countWaysUtil(s, 0, n-1, 1);
    }
    public static int countWaysUtil(String s, int i, int j, int isTrue){
        if(i > j) return 0;
        if(i == j) return  (s.charAt(i) == (isTrue == 1 ? 'T' : 'F')) ? 1 : 0;
        int tempAns = 0;
        for(int k = i+1; k <= j-1; k+=2){
            int lt = countWaysUtil(s, i, k-1, 1);
            int rt = countWaysUtil(s, k+1, j, 1);
            int lf = countWaysUtil(s, i, k-1, 0);
            int rf = countWaysUtil(s, k+1, j, 0);
            if(s.charAt(k) == '&'){
                tempAns += (isTrue == 1) ? (lt * rt) : (lt * rf + lf * rt + lf * rf);
            } else if(s.charAt(k) == '|'){
                tempAns += (isTrue == 1) ? (lt * rt + lt * rf + lf * rt) : (lf *  rf);
            } else if(s.charAt(k) == '^'){
                tempAns += (isTrue == 1) ? (lt * rf + lf * rt) : (lt * rt + lf * rf);
            }
        }
        return tempAns % 1003;
    }
    */

    //MEMOIZATION
    static int[][][] memo;
    public static int countWays(int n, String s){
        memo = new int[n][n][2];
        for(int[][] arr : memo){
            for(int[] arr1 : arr){
                Arrays.fill(arr1, -1);
            }
        }
        return countWaysUtil(s, 0, n-1, 1);
    }
    public static int countWaysUtil(String s, int i, int j, int isTrue){
        if(i > j) return 0;
        if(i == j) return  (s.charAt(i) == (isTrue == 1 ? 'T' : 'F')) ? 1 : 0;
        if(memo[i][j][isTrue] != -1) return memo[i][j][isTrue];
        int tempAns = 0;
        for(int k = i+1; k <= j-1; k+=2){
            int lt = countWaysUtil(s, i, k-1, 1);
            int rt = countWaysUtil(s, k+1, j, 1);
            int lf = countWaysUtil(s, i, k-1, 0);
            int rf = countWaysUtil(s, k+1, j, 0);
            if(s.charAt(k) == '&'){
                tempAns += (isTrue == 1) ? (lt * rt) : (lt * rf + lf * rt + lf * rf);
            } else if(s.charAt(k) == '|'){
                tempAns += (isTrue == 1) ? (lt * rt + lt * rf + lf * rt) : (lf *  rf);
            } else if(s.charAt(k) == '^'){
                tempAns += (isTrue == 1) ? (lt * rf + lf * rt) : (lt * rt + lf * rf);
            }
        }
        return memo[i][j][isTrue] = tempAns % 1003;
    }

}
