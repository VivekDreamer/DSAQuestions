package org.vivek.allCategoriesQustions.binarySearch;

//  You have been given a 2-D array ‘mat’ of size ‘N x M’ where ‘N’ and ‘M’ denote the number of rows and columns, respectively.
//  The elements of each row are sorted in non-decreasing order. 
//  Moreover, the first element of a row is greater than the last element of the previous row (if it exists). You are given an integer ‘target’, 
//  and your task is to find if it exists in the given ‘mat’ or not.
public class SearchIn2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target){
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == target) return true;
            }
        }
        return false;
    }

    public static boolean searchMatrixBetter(int[][] matrix, int target){
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0; i < n; i++){
            if(matrix[i][0] >= target && matrix[i][m-1] <= target){
                return binarySearch(matrix[i], target);
            }
        }
        return false;
    }

    private static boolean binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target) return true;
            else if(arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }

    public static boolean searchMatrixOptimal(int[][] matrix, int target){
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0;
        int high = n * m - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            int row = mid / m;
            int col = mid % m;
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] < target) low = mid + 1;
            else high = mid - 1; 
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},
                          {5,6,7,8},
                          {9,10,11,12}};

        boolean result = searchMatrixOptimal(matrix, 8);
        System.out.println(result ? "true" : "false");
    }
}
