// https://www.geeksforgeeks.org/problems/k-distance-from-root/1
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} 
class POTD_KDistanceFromRoot
{
     // Recursive function to print right view of a binary tree.
     ArrayList<Integer> Kdistance(Node root, int k){
          int level = 0;
          Queue<Node> queue = new LinkedList<>();
          ArrayList<Integer> ans = new ArrayList<>();
          queue.add(root);
          while(!queue.isEmpty()){
              int size = queue.size();
              while(size-->0){
                Node node = queue.remove();
                if(level == k){
                    ans.add(node.data);
                }
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
              }
              level++;
          }
          return ans;
     }
}
