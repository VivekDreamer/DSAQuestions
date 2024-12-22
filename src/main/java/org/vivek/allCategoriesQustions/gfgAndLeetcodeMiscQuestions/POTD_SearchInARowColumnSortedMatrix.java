// https://www.geeksforgeeks.org/problems/search-in-a-matrix17201720/1
public class POTD_SearchInARowColumnSortedMatrix {
    public static boolean matSearch(int mat[][], int x) {
        int i = 0, j = mat[0].length - 1;
        while(i < mat.length && j >= 0){
            if(mat[i][j] == x) return true;
            if(mat[i][j] > x)  j--;
            else i++;
        }
        return false;
    }
}
