package org.vivek.linkedList;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        
    }
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode start = new ListNode();
        start.next = head;
        ListNode fast = start;
        ListNode slow = start;
        for(int i = 1; i <= n; i++){
            fast = fast.next;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return start.next;
    }
}
