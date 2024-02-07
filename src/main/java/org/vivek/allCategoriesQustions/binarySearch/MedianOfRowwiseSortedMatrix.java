package org.vivek.allCategoriesQustions.binarySearch;

public class MedianOfRowwiseSortedMatrix {
    int median(int matrix[][], int R, int C) {
        int N = R * C;
        int medianIndex = N/2;
        int start = 1;
        int end = 2000;
        while(start <= end){
            int assumedMedian = start + (end - start)/2;
            //number of elements less than assumed median
            int lesserElements = findSmallerElements(matrix,assumedMedian);
            if(lesserElements <= medianIndex){
                start = assumedMedian + 1;
            } else{
                end = assumedMedian - 1;
            }
        }
        return start;
    }
    int findSmallerElements(int[][] matrix, int assumedMedian){
        int numberOfSmallerElements = 0;
        //traverse row by row
        for(int i = 0; i < matrix.length; i++){
            //matrix[i] -> 0, 1, 2
            //applying binary search on each row i.e, matrix[i]
            int start = 0;
            int end = matrix[i].length - 1;
            while(start <= end){
                int mid = start + (end - start)/2;
                if(matrix[i][mid] <= assumedMedian){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            numberOfSmallerElements += start;
        }
        return numberOfSmallerElements;
    }
}
