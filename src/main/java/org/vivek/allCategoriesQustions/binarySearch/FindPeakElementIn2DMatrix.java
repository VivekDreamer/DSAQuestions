package org.vivek.allCategoriesQustions.binarySearch;

// https://www.codingninjas.com/studio/problems/find-peak-element_7449073?utm_source=youtube&utm_medium=affiliate&utm_campaign=codestudio_Striver_BinarySeries
public class FindPeakElementIn2DMatrix {
    public static int[] findPeakGrid(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0; 
        int high = m-1;
        while(low <= high){
            int mid = low + (high - low)/2;
            int maxRowIndex = findMaxIndex(matrix,n,m,mid);
            int left = mid - 1 >= 0 ? matrix[maxRowIndex][mid-1] : -1;
            int right = mid + 1 < m ? matrix[maxRowIndex][mid+1] : -1;
            if(matrix[maxRowIndex][mid] > left && matrix[maxRowIndex][mid] > right){
                return new int[]{maxRowIndex,mid};
            } else if(matrix[maxRowIndex][mid] < left) high = mid - 1;
            else low = mid + 1;
        }
        return new int[]{-1,-1};
    }

    private static int findMaxIndex(int[][] matrix, int n, int m, int col) {
        int maxValue = -1;
        int index = -1;
        for(int i = 0; i < n; i++){
            if(matrix[i][col] > maxValue){
                maxValue = matrix[i][col];
                index = i;
            }
        }
        return index;
    }
}
