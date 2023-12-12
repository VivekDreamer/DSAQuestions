package org.vivek.dp.mixedQuestion;

import java.util.Arrays;
// https://www.geeksforgeeks.org/problems/gold-mine-problem2608/1
public class POTD_GoldMineProblem {
    static int maxGold(int n, int m, int M[][])
    {
        for(int col = m-2; col >= 0; col--){
            for(int row = 0; row < n; row++){
                int rightSide = M[row][col+1];
                int rightUpDiagonalSide = row == 0 ? 0 : M[row-1][col+1];
                int rightDownDiagonalSide = row == n-1 ? 0 : M[row+1][col+1];
                M[row][col] = M[row][col] + Math.max(rightSide , Math.max(rightUpDiagonalSide,rightDownDiagonalSide));
            }
        }
        // int max = M[0][0];
        // for(int i = 1; i< n; i++){
        //     max = Math.max(max,M[i][0]);
        // }
        // return max;
        //using stream api of java 8
        int max = Arrays.stream(M)
            .mapToInt(row -> row[0])
            .max()
            .orElse(Integer.MIN_VALUE);
        return max;
    }
}
