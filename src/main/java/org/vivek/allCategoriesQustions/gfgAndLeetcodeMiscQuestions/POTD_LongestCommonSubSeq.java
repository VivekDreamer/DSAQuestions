class POTD_LongestCommonSubSeq{
  int[][] memo;
  int lcs(String s1, String s2){
      memo = new int[s1.length()+1][s2.length()];
      for(int[] row : memo) Arrays.fill(row, -1);
      return lcsUtil(s1,s2,s1.length(),s2.length());
  }
  int lcsUtil(String s1, String s2, int n, int m){
      if(n == 0 || m == 0) return 0;
      if(memo[n][m] != -1) return memo[n][m];
      if(s1.charAt(n-1) == s2.charAt(m-1)) return memo[n][m] = 1 + lcsUtil(s1,s2,n-1,m-1);
      else return memo[n][m] = Math.max(lcsUtil(s1,s2,n-1,m) , lcsUtil(s1,s2,n,m-1));
  }
}
