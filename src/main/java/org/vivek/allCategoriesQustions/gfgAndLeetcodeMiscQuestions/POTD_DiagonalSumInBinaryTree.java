package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// https://www.geeksforgeeks.org/problems/diagonal-sum-in-binary-tree/1
public class POTD_DiagonalSumInBinaryTree {
    static class Pair
    {
        int slope;
        Node Node;
        Pair(int s,Node n)
        {
            this.Node=n;
            this.slope=s;
        }
    }
    public static ArrayList <Integer> diagonalSum(Node root) 
    {
        Queue<Pair> q=new LinkedList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        q.add(new Pair(-1,root));
        ArrayList<Integer> ans=new ArrayList<>();
        while(!q.isEmpty())
        {
            Pair p=q.poll();
            int slope=p.slope;
            Node node=p.Node;
            if(map.containsKey(slope))
            {
                map.put(slope, map.get(slope)+node.data);
            }
            else
                map.put(slope, node.data);
            if(node.right!=null)
                q.add(new Pair(slope,node.right));
            if(node.left!=null)
                q.add(new Pair(slope+1,node.left));
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet())
            ans.add(entry.getValue());
        return ans;
    }


}
