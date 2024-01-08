package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

// https://www.geeksforgeeks.org/problems/merge-2-sorted-linked-list-in-reverse-order/1
public class POTD_MergeTwoSortedLLInReverseOrder {
    Node mergeResult(Node node1, Node node2){
	    Node newHead = new Node(-1);
	    Node currList1 = node1;
	    Node currList2 = node2;
	    Node curr = newHead;
	    while(currList1 != null && currList2 != null){
	        if(currList1.data <= currList2.data){
	            curr.next = currList1;
	            currList1 = currList1.next;
	        }else{
	            curr.next = currList2;
	            currList2 = currList2.next;
	        }
	        curr = curr.next;
	    }
	    if(currList1 != null){
	        curr.next = currList1;
	    }
	    if(currList2 != null){
	        curr.next = currList2;
	    }
	    newHead = newHead.next;
        curr = newHead;
        Node prev = null;
	    while(curr != null){
	        Node nextNode = curr.next;
	        curr.next = prev;
	        prev = curr;
	        curr = nextNode;
	    }
	    return prev;
    }
    static class Node{
        int data;
	    Node next;
	    Node(int d)
	    {
		    data = d;
		    next = null;
	    }
    }
}
