// https://www.geeksforgeeks.org/problems/vertical-width-of-a-binary-tree/1
class POTD_VerticalWidthOfABinaryTree {
    public int verticalWidth(Node root) {
        if (root == null) return 0;
        Set<Integer> horizontalDistances = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            Node node = current.node;
            int hd = current.horizontalDistance;
            horizontalDistances.add(hd);
            if (node.left != null) 
                queue.add(new Pair(node.left, hd - 1));
            if (node.right != null) 
                queue.add(new Pair(node.right, hd + 1));
        }
        return horizontalDistances.size();
    }
}

class Pair {
    Node node;
    int horizontalDistance;
    Pair(Node node, int hd) {
        this.node = node;
        this.horizontalDistance = hd;
    }
}
