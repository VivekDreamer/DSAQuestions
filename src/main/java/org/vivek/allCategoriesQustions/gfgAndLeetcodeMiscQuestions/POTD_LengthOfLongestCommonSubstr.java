// https://www.geeksforgeeks.org/problems/longest-common-substring1452/1
class POTD_LengthOfLongestCommonSubstr {
    int ans = 0;
    int[][] memo;
    public int longestCommonSubstr(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        memo = new int[n+1][m+1];
        for(int[] arr : memo) Arrays.fill(arr,-1);
        longestCommonSubstrUtil(s1, s2, n, m);
        return ans;
    }
    int longestCommonSubstrUtil(String str1, String str2, int n, int m){
        if(n == 0 || m == 0) return 0;
        int temp = 0;
        if(memo[n][m] != -1) return memo[n][m];
        if(str1.charAt(n-1) == str2.charAt(m-1)) temp = longestCommonSubstrUtil(str1, str2, n-1, m-1)+1;
        longestCommonSubstrUtil(str1,str2,n-1,m);
        longestCommonSubstrUtil(str1,str2,n,m-1);
        ans = Math.max(ans,temp);
        return memo[n][m] = temp;
    }    
}
