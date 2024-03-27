package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/problems/find-shortest-safe-route-in-a-matrix/1
public class POTD_FindShortestSafeRouteInAMatrix {
    public static int findShortestPath(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] arr = new int[n][m];
        for(int[] e : arr){
            Arrays.fill(e,1);
        }
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    arr[i][j] = 0;
                    for(int k = 0; k < 4; k++){
                        int newRow = i + dr[k];
                        int newCol = j + dc[k];
                        if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m){
                            arr[newRow][newCol] = 0;
                        }
                    }
                }
            }
        }
        int[][] vis = new int[n][m];
        Queue<Tuple> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            queue.add(new Tuple(1, i, 0));
        }
        while(!queue.isEmpty()){
            Tuple tuple = queue.peek();
            queue.poll();
            int distance = tuple.distance;
            int row = tuple.row;
            int col = tuple.col;
            if(col == m-1) return distance;
            vis[row][col] = 1;
            for(int k = 0; k < 4; k++){
                int newRow = row + dr[k];
                int newCol = col + dc[k];
                if(newRow >= 0 & newRow < n && newCol >= 0 && newCol < m && vis[newRow][newCol] != 1 && arr[newRow][newCol] == 1){
                    queue.add(new Tuple(distance+1, newRow, newCol));
                }
            }
        }
        return -1;
    }
    static class Tuple{
        int distance;
        int row; 
        int col;
        public Tuple(int _distance, int _row, int _col){
            this.distance = _distance;
            this.col = _col;
            this.row = _row;
        }
    }
}
