package org.vivek.allCategoriesQustions.trees;

import java.util.ArrayList;

public class POTD_KSumPaths {
    int res = 0;
    public int sumK(Node root,int k)
    {
        // code here 
        ArrayList<Integer> list = new ArrayList<>();
        solve(root,k,list);
        return res;
    }
    public void solve(Node root, int k, ArrayList<Integer> list){
        if(root == null)return;
        list.add(root.data);
        int sum = 0;
        for(int i = list.size()-1;i>=0;i--){
            sum+=list.get(i);
            if(sum==k)res++;
        }
        solve(root.left,k,list);
        solve(root.right,k,list);
        list.remove(list.size()-1);
        
    }

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int _data){
            this.data = _data;
            left = null;
            right = null;
        }
    }
}
