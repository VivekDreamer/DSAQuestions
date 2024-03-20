package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;
// https://www.geeksforgeeks.org/problems/sum-of-the-longest-bloodline-of-a-tree/1
public class POTD_SumOfLongestBloodlineOfTree {
    
    public int sumOfLongRootToLeafPath(Node root){
        Pair pair = sumOfLongRootToLeafPathUtil(root);
        return pair.sum;
    }
    public Pair sumOfLongRootToLeafPathUtil(Node root){
        if(root == null) return new Pair(0,0);
        Pair first = sumOfLongRootToLeafPathUtil(root.left);
        Pair second = sumOfLongRootToLeafPathUtil(root.right);
        if(first.height > second.height){
            return new Pair(first.height+1,first.sum+root.data);
        }else if(first.height < second.height){
            return new Pair(second.height, second.sum+root.data);
        }else{
            return new Pair(first.height+1, Math.max(first.sum, second.sum)+root.data);
        }
    }

    static class Pair{
        private int height;
        private int sum;
        public Pair(int _height, int _sum){
            this.height = _height;
            this.sum = _sum;
        }
    }
}
