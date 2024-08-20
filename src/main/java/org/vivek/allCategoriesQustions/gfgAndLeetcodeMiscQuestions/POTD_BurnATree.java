// https://www.geeksforgeeks.org/problems/burning-tree/1
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
    	this.data = data;
    	left = null;
    	right = null;
    }
}
public class POTD_BurnATree
{   
    public static int minTime(Node root, int target) {
        Map<Node,Node> parent_track = new HashMap<>();
        Node targetNode = fillParentTrackMap(root,parent_track,target);
        Queue<Node> queue = new LinkedList<>();
        Map<Node,Boolean> visitedMap = new HashMap<>();
        queue.add(targetNode);
        visitedMap.put(targetNode,true);
        int maxi = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            int flag = 0;
            for(int i = 0; i < size; i++){
                Node node = queue.poll();
                if(node.left != null && visitedMap.get(node.left) == null){
                    visitedMap.put(node.left,true);
                    queue.add(node.left);
                    flag = 1;
                }
                if(node.right != null && visitedMap.get(node.right) == null){
                    visitedMap.put(node.right,true);
                    queue.add(node.right);
                    flag = 1;
                }
                if(parent_track.get(node) != null && visitedMap.get(parent_track.get(node)) == null){
                    visitedMap.put(parent_track.get(node),true);
                    queue.add(parent_track.get(node));
                    flag = 1;
                }
            }
            if(flag == 1) maxi++;
        }
        return maxi;
    }
    public static Node fillParentTrackMap(Node root, Map<Node,Node> parent_track, int target){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node targetNode = null;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.data == target) targetNode = node;
            if(node.left != null){
                parent_track.put(node.left,node);
                queue.add(node.left);
            }
            if(node.right != null){
                parent_track.put(node.right,node);
                queue.add(node.right);
            }
        }
        return targetNode;
    }
}
