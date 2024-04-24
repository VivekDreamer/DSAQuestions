// https://www.geeksforgeeks.org/problems/maximum-sum-of-hour-glass3842/1
class POTD_MaximumSumOfHourGlass {
    int findMaxSum(int n, int m, int mat[][]) {
        if(n < 3 || m < 3) return -1;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i+2 <= n-1 && j+2 <= m-1){
                    int firstRow = mat[i][j]+mat[i][j+1]+mat[i][j+2];
                    int midRow   = mat[i+1][j+1];
                    int lastRow  = mat[i+2][j]+mat[i+2][j+1]+mat[i+2][j+2];
                    int sum = firstRow+midRow+lastRow;
                    max = Math.max(max,sum);
                }
            }
        }
        return max;
    }
};
