// https://www.geeksforgeeks.org/problems/coverage-of-all-zeros-in-a-binary-matrix4024/1
class POTD_CoverageOfAllZerosInABinaryMatrix {
    public int FindCoverage(int[][] matrix) {
        int[] dr = {0,-1,0,1};
        int[] dc = {-1,0,1,0};
        int ans = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    for(int k = 0; k < 4; k++){
                        int newRow = i + dr[k];
                        int newCol = j + dc[k];
                        if(newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix[0].length && matrix[newRow][newCol] == 1)
                            ans++;
                    }
                }
            }
        }
        return ans;
    }
}
