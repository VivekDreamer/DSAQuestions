// https://www.geeksforgeeks.org/problems/rotate-by-90-degree-1587115621/1
public class POTD_RotateBy90_1 {
    static void rotateby90(int mat[][]) {
        int n=mat.length;
        int m=mat[0].length;
        int[][] temp=new int[n][m];
         
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j] = mat[i][j];
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mat[i][j]=temp[j][n-1-i];
            }
        }
    }
}
