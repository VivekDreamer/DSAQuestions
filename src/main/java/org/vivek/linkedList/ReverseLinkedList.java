package org.vivek.linkedList;

class ListNode{
    int val;
    ListNode next;
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
    ListNode(int val){
        this.val = val;
        this.next = null;
    }
    ListNode(){};
}
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = null;
        head = insert(head, 1);
        head = insert(head, 2);
        head = insert(head, 3);
        head = insert(head, 4);
        printLinkedList(head);
        // ListNode reverseList = reverseList(head);
        // printLinkedList(reverseList);
        ListNode reverseRcursively = reverseRcursively(head);
        printLinkedList(reverseRcursively);
    }
    public static ListNode reverseList(ListNode head){
        ListNode newHead = null;
        while(head != null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
    //1->2->3->4
    public static ListNode reverseRcursively(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode newHead = reverseRcursively(head.next);
        ListNode headNext = head.next;
        headNext.next = head;
        head.next = null;
        return newHead;
    }
    public static ListNode insert(ListNode head, int val){
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
    public static void printLinkedList(ListNode head){
        while(head.next != null){
            System.out.print(head.val+"->");
            head = head.next;
        }
        System.out.println(head.val);
    }
}
