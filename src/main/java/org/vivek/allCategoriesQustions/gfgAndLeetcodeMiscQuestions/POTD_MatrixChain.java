class POTD_MatrixChain {
    static int matrixMultiplication(int arr[]) {
        int n = arr.length;
        int[][] memo = new int[n+1][n+1];
        for(int[] row : memo) Arrays.fill(row, -1);
        return matrixMultiplicationUtil(arr, 1, n-1, memo);
    }
    static int matrixMultiplicationUtil(int[] arr, int i, int j, int[][] memo){
        if(i >= j) return 0;
        int min = Integer.MAX_VALUE;
        if(memo[i][j] != -1) return memo[i][j];
        for(int k = i; k <= j-1; k++){
            int temp = matrixMultiplicationUtil(arr, i, k, memo)
                    +  matrixMultiplicationUtil(arr, k+1, j, memo)
                    +  (arr[i-1] * arr[k] * arr[j]);
            min = Math.min(min, temp);
        }
        return memo[i][j] = min;
    }
}
