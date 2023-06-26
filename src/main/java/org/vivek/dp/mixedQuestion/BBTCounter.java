package org.vivek.dp.mixedQuestion;

import java.util.Arrays;

public class BBTCounter {
    public static void main(String[] args) {
        int h = 3;
        long countBT = countBT(h);
        System.out.println(countBT);
        long countBTDP = countBTDP(h);
        System.out.println(countBTDP);
    }
    static int MOD = (int)(1e9+7);
    static long countBT(int h){
        // code here
        long[] memo = new long[h+1];
        Arrays.fill(memo,-1);
        return countBTUtil(h,memo);
    }
    static long countBTUtil(int h, long[] memo){
        if(h == 0 || h == 1) return 1;
        if(memo[h] != -1) return memo[h];
        //there are three cases
        //1. either left subtree is of height h-1 and right subtree is of height h-2
        //2. either left subtree is of height h-2 and right subtree is of height h-1
        //3. or both the left and right subtree is of height h-1
        //this is due to the fact that in a balanced binary tree, difference between left and right subtree is atmost 1
        //countBT(h-1)*countBT(h-2) + couuntBT(h-2)*countBT(h-1) + countBT(h-1)*countBT(h-1)
        //taking countBT(h-1) commmon from all three
        //countBT(h-1)( countBT(h-2) + countBT(h-2) + countBT(h-1) )
        //countBT(h-1)((2*countBT(h-2)) + countBT(h-1));
        //return (countBT(h-1)*countBT(h-2)) + (countBT(h-2)*countBT(h-1)) + (countBT(h-1)*countBT(h-1));
    
        return memo[h] = ((countBTUtil(h-1,memo)%MOD)*((2*((countBTUtil(h-2,memo)%MOD)) + (countBTUtil(h-1,memo)%MOD)))%MOD)%MOD ;
    }

     static long countBTDP(int h){
        long[] dp = new long[h+1];
        dp[0] = 1; 
        dp[1] = 1;
        for(int i = 2; i < h+1; i++){
            dp[i] = ((dp[i-1]%MOD) * ((2*dp[i-2])%MOD + dp[i-1]%MOD)%MOD)%MOD;
        }
        return dp[h];
    }
}
