// https://www.geeksforgeeks.org/problems/find-number-of-times-a-string-occurs-as-a-subsequence3020/1
class POTD_StringSubsequence {
    static int[][] memo;
    static int MOD = (int)(1e9+7);
    public static int countWays(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n < m) return 0;
        memo = new int[n+1][m+1];
        for(int[] arr : memo) Arrays.fill(arr,-1);
        return countWaysUtil(s1,s2,n-1,m-1);
    }
    public static int countWaysUtil(String s1, String s2, int i, int j){
        if(j < 0) return 1;
        if(i < 0) return 0;
        if(memo[i][j] != -1) return memo[i][j];
        if(s1.charAt(i) == s2.charAt(j))
            return memo[i][j] = (countWaysUtil(s1,s2,i-1,j-1)%MOD+countWaysUtil(s1,s2,i-1,j)%MOD)%MOD;
        else return memo[i][j] = countWaysUtil(s1,s2,i-1,j)%MOD;
    }
}
