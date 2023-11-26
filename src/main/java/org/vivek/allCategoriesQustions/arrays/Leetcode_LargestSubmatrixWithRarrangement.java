package org.vivek.allCategoriesQustions.arrays;

import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/largest-submatrix-with-rearrangements/
public class Leetcode_LargestSubmatrixWithRarrangement {
    /*
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxArea = 0;
        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                if(matrix[row][col] == 1 && row > 0){
                    matrix[row][col] += matrix[row-1][col];
                }
            }
            int[] heights = matrix[row];
            Integer[] integerNumbers = Arrays.stream(heights).boxed().toArray(Integer[]::new);
            Arrays.sort(integerNumbers, Comparator.reverseOrder());
            for(int i = 0; i < n; i++){
                int base = i+1;
                int height = integerNumbers[i];
                maxArea = Math.max(maxArea,base*height);
            }
        }
        return maxArea;
    }
    */
    
    /*
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int result = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] != 0 && row > 0) {
                    matrix[row][col] += matrix[row - 1][col];
                }
            }
            int[] currRow = matrix[row].clone();
            Arrays.sort(currRow);
            for (int col = 0; col < n; col++) {
                int base = (n - col);
                int height = currRow[col];
                result = Math.max(result, base*height);
            }
        }
        return result;
    }
    */
    
    //Approach-2 (Without modifying the given input)
    //T.C : (m * nlogn)
    //S.C : O(m*n)
    /*
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] prevRow = new int[n];
        int result = 0;

        for (int row = 0; row < m; row++) {
            int[] currRow = matrix[row].clone();
            for (int col = 0; col < n; col++) {
                if (currRow[col] != 0) {
                    currRow[col] += prevRow[col];
                }
            }

            int[] sortedRow = currRow.clone();
            Arrays.sort(sortedRow);
            for (int i = 0; i < n; i++) {
                int base   = (n - i);
                int height = sortedRow[i];
                result = Math.max(result, base*height);
            }

            prevRow = currRow;
        }

        return result;
    }
    */
    
    //Approach-3 (Without sorting)
    //T.C : O(m*n)
    //S.C : O(m*n)
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Pair> prevHeights = new ArrayList<>(); //height,col
        int result = 0;
        for (int row = 0; row < m; row++) {
            List<Pair> heights = new ArrayList<>();
            boolean[] seen = new boolean[n];
            //i will first see those columns which has got height in previousHeights
            for (Pair entry : prevHeights) {
                int height = entry.height;
                int col = entry.col;
                if (matrix[row][col] == 1) {
                    heights.add(new Pair(height + 1, col));
                    seen[col] = true;
                }
            }
            for (int col = 0; col < n; col++) {
                if (!seen[col] && matrix[row][col] == 1) {
                    heights.add(new Pair(1, col));
                }
            }
            for (int i = 0; i < heights.size(); i++) {
                int base = i + 1;
                int height = heights.get(i).height;
                result = Math.max(result, base * height);
            }
            prevHeights = heights;
        }
        return result;
    }
    class Pair{
        int height;
        int col;
        Pair(int _height, int _col){
            this.col = _col;
            this.height = _height;
        }
    }
}
