// https://www.geeksforgeeks.org/problems/toeplitz-matrix/1
class POTD_ToeplitzMatrix {
    /*You are required to complete this method*/
    boolean isToeplitz(int mat[][]) {
        /*00 01 02 03
        10 11 12 13
        20 21 22 23
        30 31 32 33*/
        int n = mat.length;
        int m = mat[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i+1 < n && j+1 < m && mat[i][j] != mat[i+1][j+1]){
                    return false;
                } 
            }
        }
        return true;
    }
}
