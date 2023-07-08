package org.vivek.linkedList;

import java.util.ArrayList;
import java.util.List;

public class CheckForPalindromicLinkedList {
    public static void main(String[] args) {
        ListNode head = null;
        head = insertNode(head, 1);
        head = insertNode(head, 2);
        head = insertNode(head, 3);
        head = insertNode(head, 2);
        head = insertNode(head, 1);
        if(isPalindrome(head)) System.out.println("TRUE");
        else System.out.println("FALSE");
        // if(isPalindromeSecond(head)) System.out.println("TRUE");
        // else System.out.println("FALSE");
    }

    private static ListNode reverse(ListNode head){
        ListNode newNode = null;
        while(head != null){
            ListNode next = head.next;
            head.next = newNode;
            newNode = head;
            head = next;
        }
        return newNode;
    }

    private static ListNode insertNode(ListNode head, int val){
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

    //1. Find the middle element of the linked list.
    //2. Reverse a linked list from the next element of the middle element.
    //3. Iterate through the new list until the middle element reaches the end of the list.
    //4. Use a dummy node to check if the same element exists in the linked list from the middle element.
    private static boolean isPalindrome(ListNode head){
        if(head == null || head.next == null) return true;
        //first find the middle node of the linked list
        ListNode slow = head;
        ListNode fast = head;
        //this loop will run until fast pointer reaches last or second last node
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //now, reverse the second half of the list
        slow.next = reverse(slow.next);
        //move slow too the right half
        slow = slow.next;
        ListNode dummy = head;

        while(slow != null){
            if(dummy.val != slow.val) return false;
            dummy = dummy.next;
            slow = slow.next;
        }
        return true;
    }
    
    //1. Iterate through the given list to store it in an array.
    //2. Iterate through the array.
    //3. For each index in range of n/2 where n is the size of the array
    //4. Check if the number in it is the same as the number in the n-index-1 of the array.
    private static boolean isPalindromeSecond(ListNode head){
        List<Integer> arr = new ArrayList<>();
        while(head != null){
            arr.add(head.val);
            head = head.next;
        }
        for(int i = 0; i < arr.size()/2; i++){
            if(arr.get(i) != arr.get(arr.size()-i-1)) return false;
        }
        return true;
    }
}
