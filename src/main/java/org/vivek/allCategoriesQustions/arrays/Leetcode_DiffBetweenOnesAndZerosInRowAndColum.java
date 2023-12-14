package org.vivek.allCategoriesQustions.arrays;

// https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column/
public class Leetcode_DiffBetweenOnesAndZerosInRowAndColum {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] rowOnes = new int[m];
        int[] colOnes = new int[n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    rowOnes[i]++;
                    colOnes[j]++;
                }
            }
        }
        
        int[][] diff = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int onesRowi = rowOnes[i];
                int onesColj = colOnes[j];
                int zeroRowsi = n - onesRowi;
                int zeroColsj = m - onesColj; 
                diff[i][j] = onesRowi + onesColj - zeroRowsi - zeroColsj;
            }
        }
        return diff;
    }
}
