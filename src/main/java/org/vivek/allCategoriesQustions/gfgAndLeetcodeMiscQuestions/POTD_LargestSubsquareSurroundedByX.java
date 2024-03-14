package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

// https://www.geeksforgeeks.org/problems/largest-subsquare-surrounded-by-x0558/1
public class POTD_LargestSubsquareSurroundedByX {
    int largestSubsquare(int n, char a[][]) {
        int[][] psR = new int[n][n];
        int[][] psC = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                psR[i][j] = (a[i][j] == 'X' ? (j == 0 ? 1 : psR[i][j-1]+1) : 0);
                psC[j][i] = (a[j][i] == 'X' ? (j == 0 ? 1 : psC[j - 1][i] + 1) : 0);
            }
        }
        int max = 0;
        for(int i = n-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                int size = Math.min(psR[i][j], psC[i][j]);
                while(size > max){
                    if(psR[i-size+1][j] >= size && psC[i][j-size+1] >= size){
                        max = size;
                        break;
                    }
                    else size--;
                }
            }
        }
        return max;
    }
}
