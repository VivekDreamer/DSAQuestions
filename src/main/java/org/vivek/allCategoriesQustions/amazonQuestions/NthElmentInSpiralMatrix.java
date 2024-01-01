package org.vivek.allCategoriesQustions.amazonQuestions;

// https://www.geeksforgeeks.org/problems/find-nth-element-of-spiral-matrix/1
public class NthElmentInSpiralMatrix {
    public int findK(int arr[][], int n, int m, int k){
        int minRow = 0;
        int minCol = 0;
        int maxRow = n-1;
        int maxCol = m-1;
        int res = 0;
        int count = 0;
        int totalElement = n * m;
        if(k > totalElement) return -1;
        while (count < k) {
            for(int i = minRow, j = minCol; j <= maxCol && count < k; j++){
                res = arr[i][j];
                count++;
            }
            minRow++;
            for(int i = minRow, j = maxCol; i <= maxRow && count < k; i++){
                res = arr[i][j];
                count++;
            }
            maxCol--;
            for(int i = maxRow, j = maxCol; j >= minCol && count < k; j--){
                res = arr[i][j];
                count++;
            }
            maxRow--;
            for(int i = maxRow, j = minCol; i >= minRow && count < k; i--){
                res = arr[i][j];
                count++;
            }
            minCol++;
        }
        return res;
    }
}
