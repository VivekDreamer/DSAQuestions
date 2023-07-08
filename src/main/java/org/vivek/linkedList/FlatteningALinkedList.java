package org.vivek.linkedList;

class Node{
    int val;
    Node next;
    Node bottom;
    Node(int val){
        this.val = val;
        this.next = null;
        this.bottom = null;
    }
}
public class FlatteningALinkedList {

    //we will recurse until the head pointer moves null. The main motive is to merge each list from the last
    //Merge each list chosen using the merge algorithm. The steps are given below:
    //1. Create a dummy node. Point two pointers, i.e, temp and res on the dummy node. res is to keep track of dummy node
    //   and temp pointer is to move ahead as we build the flattened list.
    //2. We iterate through the two chosen. Move head from any of the chosen list ahead whose current pointed node is smaller.
    //3. return the new flattened list found.

    Node mergeTwoLists(Node a, Node b){
        Node temp = new Node(0);
        Node res = temp;
        while(a != null && b != null){
            if(a.val < b.val){
                temp.bottom = a;
                temp = temp.bottom;
                a = a.bottom;
            }else{
                temp.bottom = b;
                temp = temp.bottom;
                b = b.bottom;
            }
        }
        if(a!=null) temp.bottom = a;
        else temp.bottom = b;
        return res.bottom;
    }

    Node flatten(Node root){
        if(root == null || root.next == null)
            return root;
        //recur for list on the right
        root.next = flatten(root.next);

        //now merge
        root = mergeTwoLists(root, root.next);

        //return the root
        return root;
    }
}
