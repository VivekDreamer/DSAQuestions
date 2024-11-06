// https://www.geeksforgeeks.org/problems/root-to-leaf-paths-sum/1
class Tree
{
      int data;
      Tree left,right;
      Tree(int d){
          data=d;
          left=null;
          right=null;
      }
}
public class POTD_RootToLeafPathsSum {
    public static int treePathsSum(Node root) {
        int sum=0;
        return dfssum(root,sum);
    }
    public static int dfssum(Node root,int sum){
        if(root==null) return 0;
        sum=sum*10+root.data;
        if(root.left==null && root.right==null) return sum;
        return dfssum(root.left,sum)+dfssum(root.right,sum);
    }
}
