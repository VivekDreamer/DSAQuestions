package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

// https://www.geeksforgeeks.org/problems/delete-without-head-pointer/1
public class POTD_DeleteWithoutHeadPointer {
    void deleteNode(Node del_node){
        if(del_node == null || del_node.next == null) return;
        Node nextNode = del_node.next;
        del_node.data = nextNode.data;
        del_node.next = nextNode.next;
    }
    class Node{
	    int data ;
	    Node next;
	    Node(int d)
	    {
		    data = d;
		    next = null;
	    }
    }
}
