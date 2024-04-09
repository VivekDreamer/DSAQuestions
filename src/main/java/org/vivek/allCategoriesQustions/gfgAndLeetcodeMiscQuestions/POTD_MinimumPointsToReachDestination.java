// https://www.geeksforgeeks.org/problems/minimum-points-to-reach-destination0540/1
class POTD_MinimumPointsToReachDestination {
    public int minPoints(int points[][], int m, int n) {
       int[][] memo = new int[m][n];
       for(int[] arr : memo) Arrays.fill(arr,-1);
       return minPointsUtil(0,0,n,m,points,memo);
    }
    public int minPointsUtil(int i, int j, int n, int m, int[][] points, int[][] memo){
        if(i == m-1 && j == n-1) return 1-points[i][j];
        if(i == m || j == n) return Integer.MAX_VALUE;
        if(memo[i][j] != -1) return memo[i][j];
        int a = minPointsUtil(i,j+1,n,m,points,memo);
        int b = minPointsUtil(i+1,j,n,m,points,memo);
        return memo[i][j] = Math.max(1, Math.min(a,b)-points[i][j]);
    }
}
