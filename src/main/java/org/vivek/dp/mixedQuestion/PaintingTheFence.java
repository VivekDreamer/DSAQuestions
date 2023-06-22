package org.vivek.dp.mixedQuestion;

import java.util.Arrays;
//https://practice.geeksforgeeks.org/problems/painting-the-fence3727/1
public class PaintingTheFence {

    private static final long MOD= (long) (1e9+7);
    public static void main(String[] args) {
        int n = 3; int k = 2;
        //using recusion
        long ans1 = solveRec(n, k);
        //using memo
        long[] memo = new long[n+1];
        Arrays.fill(memo,-1);
        long ans2 = solveMem(n, k, memo);
        //using top-down
        long ans3 = solveTab(n, k);
        //using space optimization
        long ans4 = solveTabSP(n, k);
        System.out.println(ans1+" : "+ans2+" : "+ans3+" : "+ans4);
    }
    private static long solveRec(int n, int k){
        if(n == 1) return k;
        if(n == 2) return add(k,multiply(k, k-1));
        long same = multiply(solveRec(n-2, k),k-1) % MOD; //same color
        long diff = multiply(solveRec(n-1, k), k-1) % MOD; //diff color
        long ans = (same+diff) % MOD;
        return ans;
    }

    private static long solveMem(int n, int k, long[] memo){
        if(n == 1) return k;
        if(n == 2) return add(k,multiply(k, k-1));
        if(memo[n] != -1) return memo[n];
        long same = multiply(solveMem(n-2,k,memo),k-1)%MOD; // same color
        long diff = multiply(solveMem(n-1,k,memo),k-1)%MOD; // different color
        long ans = add(same,diff)%MOD;
        return memo[n] = ans;
    }

    private static long solveTab(int n,int k){
        if(n == 1) return k;
        if(n == 2) return add(k,multiply(k,k-1));
        
        long[] dp = new long[n+1];
        dp[1] = k;
        dp[2] = add(k,multiply(k,k-1));
        
        for(int i=3;i<=n;i++){
            long same = multiply(dp[i-2],k-1)%MOD; // same color
            long diff = multiply(dp[i-1],k-1)%MOD; // different color
            long ans = add(same,diff)%MOD;
            dp[i] = ans;
        }
        return dp[n];
    }

    //space optimization
    private static long solveTabSP(int n,int k){
        if(n == 1) return k;
        if(n == 2) return add(k,multiply(k,k-1));
        
        long prev2 = k;
        long prev1 = add(k,multiply(k,k-1));
        
        for(int i=3;i<=n;i++){
            long same = multiply(prev2,k-1)%MOD; // same color
            long diff = multiply(prev1,k-1)%MOD; // different color
            long ans = add(same,diff)%MOD;
            prev2 = prev1;
            prev1 = ans;
        }
        return prev1;
    }

    private static long add(long a, long b){
        return ((a%MOD) + (b%MOD))%MOD;
    }
    private static long multiply(long a, long b){
        return ((a%MOD) * (b%MOD))%MOD;
    }
}
