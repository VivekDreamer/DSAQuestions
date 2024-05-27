// https://www.geeksforgeeks.org/problems/longest-subsequence-such-that-difference-between-adjacents-is-one4724/1
class POTD_LongestSubsequence_1 {
    static int[][] memo;
    public static int longestSubseq(int n, int[] a) {
        memo = new int[n+1][n+1];
        for(int[] arr : memo) Arrays.fill(arr,-1);
        return longestSubseqUtil(a,0,-1);
    }
    public static int longestSubseqUtil(int[] arr, int curr, int prev){
        if(curr == arr.length) return 0;
        if(prev != -1 && memo[curr][prev] != -1) return memo[curr][prev];
        int take = 0;
        if(prev == -1 || Math.abs(arr[curr] - arr[prev]) == 1){
            take = 1 + longestSubseqUtil(arr, curr+1, curr);
        }
        int skip = longestSubseqUtil(arr, curr+1, prev);
        if(prev != -1) memo[curr][prev] = Math.max(take,skip);
        return Math.max(take,skip);
        
    }
    /*
    public static int longestSubseq(int n, int[] arr) {
        int[] dp = new int[n+1];
        int maxLis = 1;
        Arrays.fill(dp,1);
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(Math.abs(arr[j] - arr[i]) == 1){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    maxLis = Math.max(maxLis, dp[i]);
                }
            }
        }
        return maxLis;
    }
  */
}
