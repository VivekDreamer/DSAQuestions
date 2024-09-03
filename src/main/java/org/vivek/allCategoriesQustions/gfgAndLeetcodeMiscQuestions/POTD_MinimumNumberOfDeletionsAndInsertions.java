// https://www.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1
class POTD_MinimumNumberOfDeletionsAndInsertions
{
	public int minOperations(String a, String b) 
	{ 
	    // Your code goes here
	    //simple lcs problem
	    //we are converting String a to String b through lcs
	    //like heap -> pea
	    //lcs is ea
	    //so delete extra character in String a other than lcs i.e #deletion = len(a) - lcs = 4-2 = 2
	    //insert extra character in whatever we are getting from deletion operation. #insertion = len(b) - lcs = 3-2 = 1
	    int x = a.length(), y = b.length();
	    int[][] dp = new int[x+1][y+1];
        for(int i = 0; i < x+1; i++){
            for(int j = 0; j < y+1; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
            }
        }
        for(int i = 1; i < x+1; i++){
            for(int j = 1; j < y+1; j++){
                if(a.charAt(i-1) == b.charAt(j-1))
                    dp[i][j] = 1+dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return (x-dp[x][y])+(y-dp[x][y]);
	} 
	
}
