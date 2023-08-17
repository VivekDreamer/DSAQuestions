package org.vivek.allCategoriesQustions.trees;

import java.util.ArrayList;
import java.util.List;

// https://practice.geeksforgeeks.org/problems/k-sum-paths/1
public class T30_PrintAllKSumPathsInBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(-1);
        root.left.left = new Node(2);
        root.left.right = new Node(1);
        root.left.right.left = new Node(1);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        root.right.left.left = new Node(1);
        root.right.left.right = new Node(2);
        root.right.right.right = new Node(6);
        List<Integer> path = new ArrayList<>();
        sumK(root, path, 5);
        int sumKUtil = sumK2(root,5);
        System.out.println("Number of paths obtained : "+sumKUtil);
    }
    private static void sumK(Node root, List<Integer> path, int k){
        if(root == null) return;
        path.add(root.data);
        sumK(root.left,path,k);
        sumK(root.right, path, k);
        int f = 0;
        for(int j = path.size()-1;j>=0;j--){
            f+=path.get(j);
            if(f == k){
                for(int m = j; m < path.size(); m++){
                    System.out.print(path.get(m)+" ");
                }
                System.out.println();
            }
        }
        path.remove(path.size()-1);
    }

    static int ans = 0;
    private static int sumK2(Node root, int k){
        List<Integer> path = new ArrayList<>();
        sumK2Util(root,path,k);
        return ans;
    }
    private static void sumK2Util(Node root, List<Integer> path, int k) {
        if(root == null) return;
        path.add(root.data);
        sumK2Util(root.left, path, k);
        sumK2Util(root.right, path, k);
        int f = 0;
        for(int j = path.size()-1; j >= 0; j--){
            f+=path.get(j);
            if(f == k) ans++;
        }
        path.remove(path.size()-1);
    }

}
