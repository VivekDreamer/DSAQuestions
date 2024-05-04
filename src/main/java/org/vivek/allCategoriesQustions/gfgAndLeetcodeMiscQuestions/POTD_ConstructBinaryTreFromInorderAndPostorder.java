// https://www.geeksforgeeks.org/problems/tree-from-postorder-and-inorder/1
class Node{
    int data;
    Node left;
    Node right;
    Node(int value){
        data = value;
        left = null;
        right = null;
    }
}

public class POTD_ConstructBinaryTreFromInorderAndPostorder{
    //Function to return a tree created from postorder and inoreder traversals.
    Node buildTree(int in[], int post[], int n) {
        if(in == null || post == null || in.length != post.length) return null;
        return buildTreeUtil(in,0,n-1,post,0,n-1);
    }
    Node buildTreeUtil(int[] in, int instart, int inend, int[] post, int poststart, int postend){
        if(poststart > postend || instart > inend) return null;
        Node rootNode = new Node(post[postend]);
        int inroot = -1;
        for(int i = instart; i <= inend; i++){
            if(in[i] == post[postend]){
                inroot = i;
                break;
            }
        }
        if(inroot == -1) return null;
        int numsLeft = inroot - instart;
        rootNode.left = buildTreeUtil(in, instart, inroot-1, post, poststart, poststart + numsLeft - 1);
        rootNode.right = buildTreeUtil(in, inroot+1, inend, post, poststart + numsLeft, postend-1);
        return rootNode;
    }
}
