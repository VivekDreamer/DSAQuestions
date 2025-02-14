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

public class POTD_FixingTwoNodesOfABST {
    Node first = null, second = null, prev = null;

    void correctBST(Node root) {
        // Step 1: Identify the two swapped nodes using inorder traversal
        inorderTraversal(root);

        // Step 2: Swap their values to correct the BST
        if (first != null && second != null) {
            int temp = first.data;
            first.data = second.data;
            second.data = temp;
        }
    }

    private void inorderTraversal(Node root) {
        if (root == null) return;

        inorderTraversal(root.left);

        // Identify the misplaced nodes
        if (prev != null && prev.data > root.data) {
            if (first == null) {
                first = prev;  // First occurrence of misplaced node
            }
            second = root; // Second misplaced node (updated if found again)
        }
        prev = root; // Move to the next node

        inorderTraversal(root.right);
    }
}
