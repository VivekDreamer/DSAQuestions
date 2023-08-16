package org.vivek.allCategoriesQustions.trees;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// https://practice.geeksforgeeks.org/problems/check-mirror-in-n-ary-tree1528/1
public class T25_CheckMirrorInNAryTree {
    public static void main(String[] args) {
        int n = 3, e = 2;
        int A[] = {1, 2, 1, 3};
        int B[] = {1, 3, 1, 2};
        int checkMirrorTree = checkMirrorTree(n, e, A, B);
        System.out.println("checkMirrorTree : "+checkMirrorTree);
    }
    private static int checkMirrorTree(int n, int e, int[] A, int[] B) {
        Map<Integer,Stack<Integer>> map = new HashMap<>();
        for(int i = 0; i < A.length; i+=2){
            if(map.containsKey(A[i])){
                map.get(A[i]).push(A[i+1]);
            }
            else{
                Stack<Integer> stack = new Stack<>();
                stack.push(A[i+1]);
                map.put(A[i],stack);
            }
        }
        int i = 0;
        for(int k : map.keySet()){
            while(i < A.length && k == B[i]){
                if(map.get(k).isEmpty() || map.get(k).pop() != B[i+1])
                    return 0;
                i+=2;
            }
        }
        return 1;
    }
}
