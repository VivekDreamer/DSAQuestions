package org.vivek.allCategoriesQustions.trees;

import java.util.ArrayList;
import java.util.List;

// https://practice.geeksforgeeks.org/problems/kth-ancestor-in-a-tree/1
public class T33_KthAncestorInATree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        int kthAncestor = kthAncestor(root, 2, 4);
        int kthAncestor2 = kthAncestor2(root,1,2);
        int kthAncestor3 = kthAncestor3(root, 2, 4);
        System.out.println(kthAncestor);
        System.out.println(kthAncestor2);
        System.out.println(kthAncestor3);
    }

    //1st way...by calculating the root to node path
    static List<Node> path = new ArrayList<>();
    public static int kthAncestor(Node root, int k, int node)
    {
        path.clear();
        boolean flag = getPath(root,node);
        if(!flag) return -1;
        if(path.size() < k) return -1;
        int ans = -1;
        for(int i = path.size()-1; i >= 0; i--){
            if(k == 0) {
                ans = path.get(i).data;
                break;
            }
            k--;
        }
        return ans;
    }
    public static boolean getPath(Node root, int val){
        if(root == null) return false;
        path.add(root);
        if(root.data == val || getPath(root.left,val) || getPath(root.right,val)) return true;
        path.remove(path.size()-1);
        return false;
    }

    //2nd way
    static boolean flag;
    static int count;
    static int ans;
    private static int kthAncestor2(Node root, int k, int node){
        flag = false;
        count = 0;
        ans = Integer.MAX_VALUE;
        kthAncestorUtil(root, k, node);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    private static void kthAncestorUtil(Node root, int k, int node) {
        if(root == null) return;
        if(!flag) kthAncestorUtil(root.left, k, node);
        if(!flag) kthAncestorUtil(root.right, k, node);
        if(node == root.data){
            flag = true;
            return;
        }
        if(flag){
            count++;
            if(k == count) ans = root.data;
        }
    }

    //3rd way
    private static int kthAncestor3(Node root, int k, int node){
        int[] level = new int[]{k};
        Node ans = kthAncestor3Util(root,level,node);
        if(ans == null || ans.data == root.data) return -1;
        return ans.data;
    }
    private static Node kthAncestor3Util(Node root, int[] level, int node){
        if(root == null) return root;
        Node leftAns = kthAncestor3Util(root.left, level, node);
        Node rightAns = kthAncestor3Util(root.right, level, node);
        if(leftAns != null && rightAns == null){
            level[0]--;
            if(level[0] <= 0){
                level[0] = Integer.MAX_VALUE;
                return root;
            }
            return leftAns;
        }
        if(leftAns == null && rightAns != null){
            level[0]--;
            if(level[0] <= 0){
                level[0] = Integer.MAX_VALUE;
                return root;
            }
            return rightAns;
        }
        return null;
    }
}
