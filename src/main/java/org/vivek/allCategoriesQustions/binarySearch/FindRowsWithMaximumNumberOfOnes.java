package org.vivek.allCategoriesQustions.binarySearch;

public class FindRowsWithMaximumNumberOfOnes {

    //brute force
    public static int rowsWithMax1s(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        int countMax = 0;
        int index = -1;
        //traverse the matrix
        for(int i = 0; i < n; i++){
            int countOnes = 0;
            for(int j = 0; j < m; j++){
                countOnes += matrix[i][j];
            }
            if(countOnes > countMax){
                countMax = countOnes;
                index = i;
            }
        }
        return index;
    }

    //optimal approach
//   we can use the following formula to calculate the number of 1’s:
//   Number_of_ones = m(number of columns) – first occurrence of 1(0-based index).

//   As, each row is sorted, we can find the first occurrence of 1 in each row using any of the following approaches:

//   lowerBound(1) 
//   upperBound(0) 
//   firstOccurrence(1) 
    public static int rowsWithMax1sOptimal(int[][] matrix){
        int cntMax = 0;
        int index = -1;
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0; i < n; i++){
            int countOnes = lowerBound(matrix[i], m, 1);
            if(countOnes > cntMax){
                cntMax = countOnes;
                index = i;
            }
        }
        return index;
    }
    
    public static int lowerBound(int[] arr, int n, int k){
        int low = 0;
        int high = n-1;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] >= k) {
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }
}
