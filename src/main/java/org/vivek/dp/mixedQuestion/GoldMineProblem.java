package org.vivek.dp.mixedQuestion;

import java.util.Arrays;
//https://practice.geeksforgeeks.org/problems/gold-mine-problem2608/1
public class GoldMineProblem {
    public static void main(String[] args) {
        int n = 3, m = 3;
        int[][] M = {{1, 3, 3},
                     {2, 1, 4},
                     {0, 6, 4}};
        int maxGold = maxGold(n, m, M);
        System.out.println(maxGold);
    }
    private static int maxGold(int n, int m, int M[][]){
        for(int col = m-2; col >= 0; col--){
            for(int row = 0; row < n; row++){
                int rightSide = M[row][col+1];
                int right_up = row == 0 ? 0 : M[row-1][col+1];
                int right_down = row == n-1 ? 0 : M[row+1][col+1];
                M[row][col] = M[row][col] + Math.max(rightSide,Math.max(right_up, right_down));
            }
        }
        int max = Arrays.stream(M).mapToInt(row -> row[0]).max().orElse(Integer.MIN_VALUE);
        return max;
    }

}
