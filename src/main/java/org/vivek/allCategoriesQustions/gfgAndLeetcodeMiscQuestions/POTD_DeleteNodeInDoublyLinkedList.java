// https://www.geeksforgeeks.org/problems/delete-node-in-doubly-linked-list/1
static class Node{
    int data;
    Node next;
    Node prev;
    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}
class POTD_DeleteNodeInDoublyLinkedList {
    public Node deleteNode(Node head, int x) {
        if(x==1) return head.next;
        Node temp = head;
        for(int i = 1;i<x-1;i++) temp = temp.next;
         temp.next = temp.next.next;
         if(temp.next!=null) temp.next.prev = temp;
        return head;
    }
}
