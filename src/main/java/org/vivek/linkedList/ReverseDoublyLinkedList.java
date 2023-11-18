package org.vivek.linkedList;

public class ReverseDoublyLinkedList {
    public static Node reverseDLL(Node  head){
        Node prev = null;
        Node curr = head;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }
    static class Node
    {
        int data;
        Node next, prev;
        Node(int data)
        {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
}
