class GFG_MaximumDifferenceBetweenPairInAMatrix {
    public static int findMaxValue(int n, int[][] mat) {
        int[][] matMax = new int[n][n];
        matMax[n-1][n-1] = mat[n-1][n-1];
        //fill the last row
        for(int j = n-2; j >= 0; j--){
            matMax[n-1][j] = Math.max(mat[n-1][j], matMax[n-1][j+1]);
        }
        //fill the last col
        for(int i = n-2; i >= 0; i--){
            matMax[i][n-1] = Math.max(mat[i][n-1], matMax[i+1][n-1]);
        }
        //fill the rest matrix
        for(int i = n-2; i >= 0; i--){
            for(int j = n-2; j >= 0; j--){
                matMax[i][j] = Math.max(mat[i][j],Math.max(matMax[i][j+1],Math.max(matMax[i+1][j+1],matMax[i+1][j])));
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < n-1; j++){
                ans = Math.max(ans, matMax[i+1][j+1] - mat[i][j]);
            }
        }
        return ans;
    }
}
        
