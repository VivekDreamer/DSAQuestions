package org.vivek.linkedList;

import java.util.HashSet;
import java.util.Set;

public class StartingPointOfCycle {
    public static void main(String[] args) {
        ListNode head = null;
        head = insertNode(head, 1);
        head = insertNode(head, 2);
        head = insertNode(head, 3);
        head = insertNode(head, 4);
        head = insertNode(head, 3);
        head = insertNode(head, 6);
        head = insertNode(head, 10);
        createCycle(head, 2);
        ListNode nodeRecieve = detectCycle(head);
        if(nodeRecieve == null) System.out.println("No cycle");
        else{
            ListNode temp = head;
            int pos = 0;
            while(temp != nodeRecieve){
                ++pos;
                temp = temp.next;
            }
            System.out.println("Tail connects at pos "+pos);
        }
    }

    public static ListNode insertNode(ListNode head, int val){
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

    public static void printList(ListNode head){
        while(head.next != null){
            System.out.print(head.val+"->");
            head = head.next;
        }
        System.out.println(head.val);
    }

    public static void createCycle(ListNode head, int pos){
        ListNode ptr = head;
        ListNode temp = head;
        int cnt = 0;
        while(temp.next != null){
            if(cnt != pos){
                ++cnt;
                ptr = ptr.next;
            }
            temp = temp.next;
        }
        temp.next = ptr;
    }

    public static ListNode detectCycle(ListNode head){
        Set<ListNode> set = new HashSet<>();
        while(head != null){
            if(set.contains(head)) return head;
            set.add(head);
            head = head.next;
        }
        return null;
    }

//1. Initially take two pointers, fast and slow. The fast pointer takes two steps ahead while the slow pointer will take a single step ahead for each iteration.
//2. We know that if a cycle exists, fast and slow pointers will collide.
//3. If the cycle does not exist, the fast pointer will move to NULL
//4. Else, when both slow and fast pointer collides, it detects a cycle exists.
//5. Take another pointer, say entry. Point to the very first of the linked list.
//6. Move the slow and the entry pointer ahead by single steps until they collide. 
//7. Once they collide we get the starting node of the linked list.
    public static ListNode detectCycleOptimized(ListNode head){
        if(head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode entry = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                while(slow != entry){
                    slow = slow.next;
                    entry = entry.next;
                }
                return slow;
            }
        }
        return null;
    }
}
