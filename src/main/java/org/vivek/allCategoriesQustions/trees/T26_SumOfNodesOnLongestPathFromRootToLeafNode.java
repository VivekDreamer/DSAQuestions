package org.vivek.allCategoriesQustions.trees;

// https://practice.geeksforgeeks.org/problems/sum-of-the-longest-bloodline-of-a-tree/1
public class T26_SumOfNodesOnLongestPathFromRootToLeafNode {
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(7);
        root.left.right = new Node(1);
        root.right.left = new Node(2);
        root.right.right = new Node(3);
        root.left.right.left = new Node(6);
        int sumOfLongRootToLeafPath = sumOfLongRootToLeafPath(root);
        int sumOfLongRootToLeafPath2 = sumOfLongRootToLeafPath2(root);
        System.out.println(sumOfLongRootToLeafPath);
        System.out.println(sumOfLongRootToLeafPath2);
    }
    private static int sumOfLongRootToLeafPath(Node root)
    {
        Pair pair = solve(root);
        return pair.sum;
    }
    
    private static Pair solve(Node root) {
        if(root == null) return new Pair(0,0);
        Pair left = solve(root.left);
        Pair right = solve(root.right);
        if(left.height > right.height) return new Pair(left.height+1,left.sum+root.data);
        else if (left.height < right.height) return new Pair(right.height+1,right.sum+root.data);
        else return new Pair(left.height+1, Math.max(left.sum, right.sum)+root.data);
    }

    static class Pair{
        int height;
        int sum;
        public Pair(int height, int sum) {
            this.height = height;
            this.sum = sum;
        }
    }

    private static int sumOfLongRootToLeafPath2(Node root){
        int len = 0;
        int maxlen[] = new int[]{0};
        int sum = 0;
        int maxSum[] = new int[]{0};
        solve(root,len,maxlen,sum,maxSum);
        return maxSum[0];

    }
    private static void solve(Node root, int len, int[] maxlen, int sum, int[] maxSum) {
        if(root == null){
            if(len > maxlen[0]){
                maxlen[0] = len;
                maxSum[0] = sum;
            }else if(len == maxlen[0]){
                maxSum[0] = Math.max(maxSum[0], sum);
            }
            return;
        }
        sum += root.data;
        solve(root.left, len+1, maxlen, sum, maxSum);
        solve(root.right, len+1, maxlen, sum, maxSum);
    }

}
