// https://www.geeksforgeeks.org/problems/left-rotate-matrix-k-times2351/1
class POTD_LeftRotateMatrixKTimes {
    int[][] rotateMatrix(int k, int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] ans = new int[n][m];
        k %= m;
        if(k == 0) return mat;
        for(int i = 0; i < n; i++){
            int x = 0;
            for(int j = k; j < m; j++, x++){
                ans[i][x] = mat[i][j];
            }
            for(int j = 0; j < k; j++, x++){
                ans[i][x] = mat[i][j];
            }
        }
        return ans;
    }
}
