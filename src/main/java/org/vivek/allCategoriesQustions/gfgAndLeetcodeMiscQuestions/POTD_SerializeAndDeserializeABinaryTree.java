// https://www.geeksforgeeks.org/problems/serialize-and-deserialize-a-binary-tree/1
class Tree{
    int data;
    Tree left,right;
    Tree(int d){
        data=d;
        left=right=null;
    }
}

class POTD_SerializeAndDeserializeABinaryTree {
    // Function to serialize a tree and return a list containing nodes of tree.
    public ArrayList<Integer> serialize(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if(root == null){
            arr.add(-1);
            return arr;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.remove();
            if(node == null){
                arr.add(-1);
                continue;
            }
            arr.add(node.data);
            queue.add(node.left);
            queue.add(node.right);
        }
        return arr;
    }

    // Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> arr) {
        if(arr.size() == 0) return null;
        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(arr.get(0));
        queue.add(root);
        int i = 1;
        while(i < arr.size()){
            Node parent = queue.remove();
            if(arr.get(i) != -1){
                Node leftNode = new Node(arr.get(i));
                parent.left = leftNode;
                queue.add(leftNode);
            }
            if(arr.get(++i) != -1){
                Node rightNode = new Node(arr.get(i));
                parent.right = rightNode;
                queue.add(rightNode);
            }
            i++;
        }
        return root;
    }
};
