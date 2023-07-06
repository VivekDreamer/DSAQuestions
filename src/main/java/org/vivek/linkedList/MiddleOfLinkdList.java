package org.vivek.linkedList;

public class MiddleOfLinkdList {
    public static void main(String[] args) {
        
    }
    public ListNode middleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
