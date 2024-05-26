// https://www.geeksforgeeks.org/problems/minimum-cost-to-make-two-strings-identical1107/1
class POTD_MinimumCostToMakeTwoStringsIdentical {
    int[][] memo;
    public int findMinCost(String x, String y, int costX, int costY) {
        memo = new int[x.length()+1][y.length()+1];
        for(int[] arr : memo) Arrays.fill(arr,-1);
        int c = lcs(x,y,0,0);
        int len1 = x.length();
        int len2 = y.length();
        return ((len1 - c)*(costX) + (len2 - c)*(costY));
    }
    public int lcs(String s1, String s2, int i, int j){
        if(i == s1.length() || j == s2.length()) return 0;
        if(memo[i][j] != -1) return memo[i][j];
        if(s1.charAt(i) == s2.charAt(j)) return memo[i][j] = 1 + lcs(s1, s2, i+1, j+1);
        return memo[i][j] = Math.max(lcs(s1,s2,i+1,j),lcs(s1,s2,i,j+1));
    }
}
