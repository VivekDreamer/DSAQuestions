package org.vivek.linkedList;

import java.util.HashSet;
import java.util.Set;

public class DetectCycleInLinkedList {
    public static void main(String[] args) {
        ListNode head = null;
        head = insertNode(head, 1);
        head = insertNode(head, 2);
        head = insertNode(head, 3);
        head = insertNode(head, 4);
        createCycle(head, 1, 3);
        
        if(hasCycle(head)) System.out.println("cycle detected");
        else System.out.println("cycle not detected");

        if(hasCycleHashing(head))System.out.println("cycle detected");
        else System.out.println("cycle not detected");
    }

    private static ListNode insertNode(ListNode head, int val){
        ListNode node = new ListNode(val);
        if(head == null){
            head = node;
            return head;
        }
        ListNode temp = head;
        while(temp.next != null) temp = temp.next;
        temp.next = node;
        return head;
    }
    //utility function to create cycle
    private static void createCycle(ListNode head, int a, int b){
        int cnta = 0, cntb = 0;
        ListNode p1 = head;
        ListNode p2 = head;
        while(cnta != a || cntb != b){
            if(cnta != a){
                p1 = p1.next;
                ++cnta;
            }
            if(cntb != b){
                p2 = p2.next;
                ++cntb;
            }
        }
        p2.next = p1;
    }

    private static boolean hasCycle(ListNode head){
        ListNode temp = head;
        if(temp == null || temp.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast)
                return true;
        }
        return false;
    }    

    private static boolean hasCycleHashing(ListNode head){
        Set<ListNode> set = new HashSet<>();
        while(head != null){
            if(set.contains(head)) return true;
            set.add(head);
            head = head.next;
        }
        return false;
    }
}
