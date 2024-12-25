// https://www.geeksforgeeks.org/problems/set-matrix-zeroes/1
public class POTD_SetMatrixZero {
    /*
    public void setMatrixZeroes(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] row = new int[n];
        int[] col = new int[m];
        Arrays.fill(row,-1);
        Arrays.fill(col,-1);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    row[i] = 0;
                    col[j] = 0;
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            if(row[i] == 0){
                for(int j = 0; j < m; j++){
                    mat[i][j] = 0;
                }
            }
        }
        
        for(int j = 0; j < m; j++){
            if(col[j] == 0){
                for(int i = 0; i < n; i++){
                    mat[i][j] = 0;
                }
            }
        }
    }
    */
    
    public void setMatrixZeroes(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;
        
        for(int i=0; i<r; i++){
            if(mat[i][0]==0){
                firstColHasZero = true;
                break;
            }
        }
        
        for(int j=0; j<c; j++){
            if(mat[0][j]==0){
                firstRowHasZero = true;
                break;
            }
        }
        
        for(int i=1; i<r; i++){
            for(int j=1; j<c; j++){
                if(mat[i][j]==0){
                    mat[i][0]=0;
                    mat[0][j]=0;
                }
            }
        }
        
        for(int i=1; i<r; i++){
            if(mat[i][0]==0){
                for(int j=1; j<c; j++){
                    mat[i][j] = 0;
                }
            }
        }
        
        for(int j=1; j<c; j++){
            if(mat[0][j]==0){
                for(int i=1; i<r; i++){
                    mat[i][j] = 0;
                }
            }
        }
        
        if(firstRowHasZero){
            for(int j=0; j<c; j++){
                mat[0][j] = 0;
            }
        }
        
        if(firstColHasZero){
            for(int i=0; i<r; i++){
                mat[i][0] = 0;
            }
        }
    }
}
