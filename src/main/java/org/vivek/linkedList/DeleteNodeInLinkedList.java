package org.vivek.linkedList;

public class DeleteNodeInLinkedList {
    //function to insert the node at the end of the list
    static ListNode insertNode(ListNode head, int val){
        ListNode newNode = new ListNode(val);
        if(head == null){
            head = newNode;
            return head;
        }
        ListNode temp = head;
        while(temp.next != null) temp = temp.next;
        temp.next = newNode;
        return head;
    }
    //function to get the reference of the node to be deleted
    static ListNode getNode(ListNode head, int val){
        if(head == null) return null;
        while(head.val != val) head = head.next;
        return head;
    }
    //delete function as per the question
    static void deleteNode(ListNode nodeToBeDeleted){
        if(nodeToBeDeleted == null) return;
        nodeToBeDeleted.val = nodeToBeDeleted.next.val;
        nodeToBeDeleted.next = nodeToBeDeleted.next.next;
        return;
    }
    //printing the list
    static void printList(ListNode head){
        if(head == null) return;
        while(head.next != null){
            System.out.print(head.val+"->");
            head = head.next;
        }
        System.out.print(head.val);
    }
    public static void main(String[] args) {
        ListNode head = null;
        //inserting node
        head = insertNode(head,1);
        head = insertNode(head,4);
        head = insertNode(head,2);
        head = insertNode(head,3);

        //printimg the given list
        System.out.println("given list is : ");
        printList(head);
        ListNode t = getNode(head, 2);
        //deleteNode
        deleteNode(t);
        //after deletion
        System.out.println("given list is : ");
        printList(head);
    }
}
