package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

import java.util.ArrayList;
// https://www.geeksforgeeks.org/problems/euler-circuit-in-a-directed-graph/1
public class POTD_EulerCircuitInAnUndirectedGraph {
    public boolean isEularCircuitExist(int v, ArrayList<ArrayList<Integer>> adj) {
        int even = 0;
        for(ArrayList<Integer> arr : adj){
            if(arr.size() % 2 == 0) even++;
        }
        return (even == v);
    }
}
