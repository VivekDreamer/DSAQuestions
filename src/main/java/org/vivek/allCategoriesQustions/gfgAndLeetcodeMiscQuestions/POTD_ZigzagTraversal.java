package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/problems/zigzag-tree-traversal/1
public class POTD_ZigzagTraversal {
    ArrayList<Integer> zigZagTraversal(Node root)
	{
	    ArrayList<Integer> list = new ArrayList<>();
	    if(root == null)
	        return list;
	    Queue<Node> queue = new LinkedList<>();
	    queue.add(root);
	    boolean flag = true;
	    while(!queue.isEmpty())
	    {
	        int level = queue.size();
	        ArrayList<Integer> subList = new ArrayList<>();
	        int sizeOfList = list.size();
	        for(int i = 0; i < level; i++){
	           Node curr = queue.poll();
	           if(curr.left != null) queue.add(curr.left);
	           if(curr.right != null) queue.add(curr.right);
	           if(flag == true)
	                list.add(curr.data);
	           else 
	                list.add(sizeOfList,curr.data);
	        }
	        flag = !flag;
	    }
	    return list;
	}
}
