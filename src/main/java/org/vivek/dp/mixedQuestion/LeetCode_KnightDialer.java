package org.vivek.dp.mixedQuestion;

import java.util.Arrays;
import java.util.List;

public class LeetCode_KnightDialer {
    private static final List<List<Integer>> adj = Arrays.asList(
        Arrays.asList(4,6),
        Arrays.asList(6, 8),
        Arrays.asList(7, 9),
        Arrays.asList(4, 8),
        Arrays.asList(3, 9, 0),
        Arrays.asList(),
        Arrays.asList(1, 7, 0),
        Arrays.asList(2, 6),
        Arrays.asList(1, 3),
        Arrays.asList(2, 4)
    );
    private int[][] memo = new int[5001][10];
    private static final int MOD = 1000000007;
    //recursion
    /*
    public int knightDialer(int n) {
        int result = 0;
        for(int cell = 0; cell <= 9; cell++){
            result = result + (knightDialerUtil(n-1,cell));
        }
        return result;
    }
    public int knightDialerUtil(int n, int cell){
        if(n == 0){
            return 1;
        }
        int res = 0;
        for(int nextCell : adj.get(cell)){
            res = res + (knightDialerUtil(n-1,nextCell));
        }
        return res;
    }
    */
    
    //memoization
    //T.C : O(n*9) Total n*k states
    //S.C : O(n*9)
    /*
    public int knightDialer(int n) {
        int result = 0;
        Arrays.stream(memo).forEach(row -> Arrays.fill(row, -1));
        for(int cell = 0; cell <= 9; cell++){
            result = (result + (knightDialerUtil(n-1,cell))) % MOD;
        }
        return result;
    }
    public int knightDialerUtil(int n, int cell){
        if(n == 0){
            return 1;
        }
        if(memo[n][cell] != -1){
            return memo[n][cell];
        }
        int res = 0;
        for(int nextCell : adj.get(cell)){
            res = (res + (knightDialerUtil(n-1,nextCell))) % MOD;
        }
        return memo[n][cell] = res;
    }
    */
    
    //bottom - up
    //T.C : O(n*10)
    //S.C : O(n*10)
    public int knightDialer(int n) {
        int result = 0;
        // t[i][j] = number of ways to form a number of length i when I am currently at cell j
        int[][] t = new int[n][10];
        for (int cell = 0; cell < 10; cell++) {
            t[0][cell] = 1; // for n == 0, we always return 1
        }
        for (int i = 1; i < n; i++) { // This is the length of the number
            for (int cell = 0; cell <= 9; cell++) {
                int ans = 0;
                for (int nextCell : adj.get(cell)) {
                    ans = (ans + t[i - 1][nextCell]) % MOD;
                }
                t[i][cell] = ans;
            }
        }
        for (int cell = 0; cell <= 9; cell++) {
            result = (result + t[n - 1][cell]) % MOD;
        }
        return result;
    }
}
