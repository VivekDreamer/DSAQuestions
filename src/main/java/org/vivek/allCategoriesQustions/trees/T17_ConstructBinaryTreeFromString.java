package org.vivek.allCategoriesQustions.trees;

import java.util.Stack;

// https://practice.geeksforgeeks.org/problems/construct-binary-tree-from-string-with-bracket-representation/1
public class T17_ConstructBinaryTreeFromString {
    public static void main(String[] args) {
        String str = "1(2)(3)";
        Node node = treeFromString(str);
        preorder(node);
    }
    public static Node treeFromString(String s) {
        return treeFromStringUtil(s, 0, s.length()-1);
    }
    private static Node treeFromStringUtil(String s, int left, int right) {
        if(left > right) return null;
        int i = left;
        while(i <= right){
            char ch = s.charAt(i);
            if(ch >= '0' && ch <= '9') i++;
            else break;
        }
        Node ans = new Node(Integer.parseInt(s.substring(left,i)));
        int j = i;
        Stack<Character> stack = new Stack<>();
        while(j <= right){
            char ch = s.charAt(j);
            if(ch == ')') stack.pop();
            else if(ch == '(') stack.push('(');
            if(stack.size() == 0) break;
            j++;
        }
        ans.left = treeFromStringUtil(s,i+1,j-1);
        if(j+2 < right) ans.right = treeFromStringUtil(s,j+2,right-1);
        return ans;
    }
    public static void preorder(Node root){
        if(root == null) return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
}
