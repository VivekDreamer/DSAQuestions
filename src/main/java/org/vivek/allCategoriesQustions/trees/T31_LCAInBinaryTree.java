package org.vivek.allCategoriesQustions.trees;

import java.util.ArrayList;
import java.util.List;

// https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-binary-tree/1
public class T31_LCAInBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        root.right.left.left = new Node(8);
        root.right.right.left = new Node(6);
        root.right.right.right = new Node(7);
        
        Node lca = lca(root, root.right.right.right , root.right.left.left );
        Node lca2 = lca2(root, root.right.right.right , root.right.left.left );
        Node lca3 = lca3(root,7,8);
        System.out.println("lca : "+lca.data);
        System.out.println("lca : "+lca2.data);
        System.out.println("lca : "+lca3.data);
    }
    private static Node lca(Node root, Node node1, Node node2){
        if(root == null || root == node1 || root == node2) return root; //whenever the root becomes null or we get the desired node...return from that node.
        Node left = lca(root.left, node1, node2);
        Node right = lca(root.right,node1,node2);
        if(left == null) return right; //if null comes from left side...return whatever is in the right
        else if (right == null) return left; //if null comes from right side...return whatever is in the left
        else return root; //if both are not null then, return whatever the root is.
	}

    private static Node lca2(Node root, Node node1, Node node2){
        if(root == null || root == node1 || root == node2)return root;
        Node left = lca(root.left,node1,node2);
        Node right = lca(root.right,node1,node2);
        if(left!=null && right != null)return root;
        return left == null ? right:left;
    }

    //brute force
    static List<Node> path1 = new ArrayList<>();
    static List<Node> path2 = new ArrayList<>();
    private static Node lca3(Node root, int n1, int n2){
        path1.clear();
        path2.clear();
        return findLCAInternal(root, n1, n2);
    }
    private static Node findLCAInternal(Node root, int n1, int n2) {
        if(!findPath(root,n1,path1) || !findPath(root,n2,path2)) return new Node(-1);
        int i;
        for(i = 0; i < path1.size() && i < path2.size(); i++){
            if (!path1.get(i).equals(path2.get(i)))
                break;
        }
        return path1.get(i - 1);
    }
    private static boolean findPath(Node root, int n, List<Node> path) {
        // base case
        if (root == null) {
            return false;
        }
        // Store this node . The node will be removed if
        // not in path from root to n.
        path.add(root);
        if (root.data == n ||
            findPath(root.left, n, path) ||
            findPath(root.right, n, path)) {
            return true;
        }
        // If not present in subtree rooted with root,
        // remove root from path[] and return false
        path.remove(path.size() - 1);
        return false;
    }
}
