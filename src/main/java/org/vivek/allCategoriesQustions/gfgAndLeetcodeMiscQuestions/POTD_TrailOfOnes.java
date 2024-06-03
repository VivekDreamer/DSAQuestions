// https://www.geeksforgeeks.org/problems/trail-of-ones3242/1
class POTD_TrailOfOnes {
    static int MOD = 1000000007;
    static int numberOfConsecutiveOnes(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0; //no binary strings of length 0
        dp[1] = 0; //no binary strings of length 1 having consecutive ones
        dp[2] = 1; // "11" is the only binary strings having consecutive ones
        if(n < 3) return dp[n];
        int a = 0;
        int b = 1;
        for(int i = 3; i <= n; i++){
            int c = (a+b)%MOD;
            dp[i] = ((dp[i-1]*2)%MOD + c) % MOD;
            a = b;
            b = c;
        }
        return dp[n];
    }
}
