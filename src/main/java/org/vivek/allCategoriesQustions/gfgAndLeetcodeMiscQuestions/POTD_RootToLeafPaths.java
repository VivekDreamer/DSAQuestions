// https://www.geeksforgeeks.org/problems/root-to-leaf-paths/1
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
public class POTD_RootToLeafPaths {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        rootToLeafPath(root, list, ans);
        return ans;
    }
    public static void rootToLeafPath(Node root, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ans){
        if(root == null)return;
        list.add(root.data);
        if(root.left == null && root.right == null) 
             ans.add(new ArrayList<>(list));
        rootToLeafPath(root.left, list, ans);
        rootToLeafPath(root.right, list, ans);
        list.remove(list.size()-1);
    }
}
        
