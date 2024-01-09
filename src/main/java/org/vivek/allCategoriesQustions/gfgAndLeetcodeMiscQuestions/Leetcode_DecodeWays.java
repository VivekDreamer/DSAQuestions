package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

// https://leetcode.com/problems/decode-ways/
public class Leetcode_DecodeWays {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 1) {
            return s.charAt(0) == '0' ? 0 : 1;
        }
        if (s.charAt(0) == '0') {
            return 0;
        }
        int last1 = 1, last2 = 1;
        for (int i = 1; i < n; i++) {
            int count = s.charAt(i) != '0' ? last1 : 0;
            if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) < '7')) {
                count += last2;
            }
            last2 = last1;
            last1 = count;
        }
        return last1;
    }
    
    //recursion
    /* 
    public int numDecodings(String s) {
        int n = s.length(); 
        return numDecodingsUtils(0,s,n);
    }
    
    public int numDecodingsUtils(int i, String s, int n){
        if(i == n) return 1;
        if(s.charAt(i) == '0') return 0;
        int result = numDecodingsUtils(i+1,s,n);
        if(i+1 < n){
            if(s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) <= 6))
                result += numDecodingsUtils(i+2,s,n);
        }
        return result;
    }
    */

    /*
    public int numDecodings(String s) { 
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7')) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];    
    }
    */
    
    /*
     public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        //dp[i] = ways to decode string from index i to n
        Arrays.fill(dp, 0);
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1];
                if (i < n - 1 && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7'))) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }
    */
    
    /*
    int[] memo;
    public int numDecodings(String s) {
        int n = s.length(); 
        memo = new int[101];
        Arrays.fill(memo,-1);
        return numDecodingsUtils(0,s,n);
    }
    
    public int numDecodingsUtils(int i, String s, int n){
        if(memo[i] != -1) return memo[i];
        if(i == n) return memo[i] = 1;
        if(s.charAt(i) == '0') return memo[i] = 0;
        int result = numDecodingsUtils(i+1,s,n);
        if(i+1 < n){
            if(s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) <= '6'))
                result += numDecodingsUtils(i+2,s,n);
        }
        return memo[i] = result;
    }
    */
    
    /*
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        dp[0] = 1;
        if(s.charAt(0) == '0') return 0;
        for(int i = 1; i < dp.length; i++){
            if(s.charAt(i-1) == '0' && s.charAt(i) == '0'){
                dp[i] = 0;
            } else if(s.charAt(i-1) == '0' && s.charAt(i) != '0'){
                dp[i] = dp[i-1];
            } else if(s.charAt(i-1) != '0' && s.charAt(i) == '0'){
                if(s.charAt(i-1) == '1' || s.charAt(i-1) == '2'){
                    dp[i] = (i >= 2 ? dp[i-2] : 1);
                } else{
                    dp[i] = 0;
                }
            } else {
                if(Integer.parseInt(s.substring(i-1,i+1)) <= 26){
                    dp[i] = dp[i-1] + (i >= 2 ? dp[i-2] : 1);
                } else {
                    dp[i] = dp[i-1];
                }
            }
        }
        return dp[s.length()-1];
    }
    */
}
