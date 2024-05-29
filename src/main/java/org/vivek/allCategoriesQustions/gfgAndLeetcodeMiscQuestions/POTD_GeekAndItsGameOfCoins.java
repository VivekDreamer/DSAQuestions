// https://www.geeksforgeeks.org/problems/geek-and-its-game-of-coins4043/1
class POTD_GeekAndItsGameOfCoins {
    public static int findWinner(int n, int x, int y) {
        boolean []dp= new boolean[n+1];
        dp[1]=true;
        for(int i=2;i<dp.length;i++){
            if(dp[i-1]==false)dp[i]=true;
            else if(i-x>=0 && dp[i-x]==false)dp[i]=true;
            else if(i-y>=0 && dp[i-y]==false)dp[i]=true;
            else dp[i]=false;
        }
        return dp[n]==true?1:0;
    }
}
