package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

// https://www.geeksforgeeks.org/problems/castle-run3644/1
public class POTD_CountAllPossiblePaths {
    public int isPossible(int[][] paths){
        //euler path
        int v = paths.length;
        int[] indegree = new int[v];
        for(int i = 0; i < v; i++){
            for(int j = 0; j < v; j++){
                if(paths[i][j] == 1)
                    indegree[i]++;
            }
        }
        for(int i = 0; i < v; i++){
            if(indegree[i] % 2 != 0) return 0;
        }
        return 1;
    }
}
