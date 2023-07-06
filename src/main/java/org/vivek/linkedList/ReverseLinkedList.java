package org.vivek.linkedList;

class ListNode{
    int val;
    ListNode next;
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
    ListNode(){

    }
    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}
public class ReverseLinkedList {
    public static void main(String[] args) {
        
    }
    public ListNode reverseList(ListNode head){
        ListNode newHead = null;
        while(head != null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
