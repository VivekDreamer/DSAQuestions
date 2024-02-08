package org.vivek.allCategoriesQustions.binarySearch;

// https://leetcode.com/problems/search-a-2d-matrix-ii/
public class SearchIn2DMatrixII {
    public static boolean search(int[][] matrix, int target){
        int n = matrix.length;
        int m = matrix[0].length;
        int row = 0, col = m-1;
        while(row < n && col >= 0){
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] < target) row++;
            else col++;
        }
        return false;
    }
}
