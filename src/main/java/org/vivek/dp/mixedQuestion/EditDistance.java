package org.vivek.dp.mixedQuestion;

import java.util.Arrays;
//https://practice.geeksforgeeks.org/problems/edit-distance3702/1
public class EditDistance {
    public static void main(String[] args) {
        String s = "geek";
        String t = "gesek";
        int editDistance = editDistance(s, t);
        System.out.println(editDistance);
    }
    private static int editDistance(String s, String t){
        int[][] memo = new int[s.length()+1][t.length()+1];
        for(int[] row : memo)
            Arrays.fill(row,-1);
        return editDistanceUtil(s, t, 0, 0, memo);
    }
    private static int editDistanceUtil(String s, String t, int i, int j, int[][] memo) {
        if(i == s.length()) return t.length()-j;
        if(j == t.length()) return s.length()-i;
        if(memo[i][j] != -1) return memo[i][j];
        int ans = 0;
        if(s.charAt(i) == t.charAt(j))
            return editDistanceUtil(s, t, i+1, j+1, memo);
        else{
            int insert  = 1 + editDistanceUtil(s, t, i, j+1, memo);
            int delete  = 1 + editDistanceUtil(s, t, i+1, j, memo);
            int replace = 1 + editDistanceUtil(s, t, i+1, j+1, memo);
            ans = Math.min(insert,Math.min(delete, replace));
        }
        return memo[i][j] = ans;
    }
}
