package org.vivek.linkedList;

public class ReverseLinkedListInGroupOfKSize {
    public static void main(String[] args) {
        ListNode head = null;
        head = insertNode(head, 1);
        head = insertNode(head, 2);
        head = insertNode(head, 2);
        head = insertNode(head, 4);
        head = insertNode(head, 5);
        head = insertNode(head, 6);
        head = insertNode(head, 7);
        head = insertNode(head, 8);
        printLinkedList(head);
        ListNode reverse = reverse(head, 4);
        printLinkedList(reverse);
    }
    // 1->2->2->4->5->6->7->8
    // k = 4
    // 4->2->2->1->8->7->6->5
    public static ListNode reverse(ListNode head, int k){
        if(head == null) return null;
        ListNode curr = head;
        ListNode prev = null;
        int i = 0;
        while(i < k && curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }
        ListNode ans = reverse(curr, k);
        head.next = ans;
        return prev;
    }
    public static ListNode insertNode(ListNode head, int val){
        ListNode newNode = new ListNode(val);
        if(head == null){
            head = newNode;
            return head;
        }
        ListNode temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
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
