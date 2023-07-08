package org.vivek.linkedList;

public class RotateTheLinkedList {
    public static void main(String[] args) {
        ListNode head = null;
        head = insert(head, 1);
        head = insert(head, 2);
        head = insert(head, 3);
        head = insert(head, 4);
        head = insert(head, 5);
        System.out.println("original list : ");
        printLinkedList(head);

        int k = 2;
        ListNode newHead = rotateRight(head, k);
        System.out.println("After "+k+" iterations : ");
        printLinkedList(newHead);
    }

    public static ListNode insert(ListNode head, int val){
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
        ListNode temp = head;
        while(temp.next != null){
            System.out.print(temp.val+"->");
            temp = temp.next;
        }
        System.out.println(temp.val);
    }

    // Brute force
    // 1. we have to move the last element to first for each keep
    // 2. For each k, find the last element from the list and move it to the first.

    public static ListNode rotateRight(ListNode head, int k){
        if(head == null || head.next == null) return head;
        for(int i = 0; i < k; i++){
            ListNode temp = head;
            while(temp.next.next != null) temp = temp.next;
            ListNode end = temp.next;
            temp.next = null;
            end.next = head;
            head = end;
        }
        return head;
    }

    //  Calculate the length of the list.
    //  Connect the last node to the first node, converting it to a circular linked list.
    //  Iterate to cut the link of the last node and start a node of k%length of the list rotated list.
    public static ListNode rotateRightOptimized(ListNode head, int k){
        //base condition
        if(head == null || head.next == null || k == 0) return head;
        //calculate length of list
        ListNode temp = head;
        int length = 1;
        while(temp.next != null){
            ++length;
            temp = temp.next;
        }

        //link the last node to first node to make it circular LL
        temp.next = head;
        k = k % length; //when k is more than the length of ll
        int end = length-k; //to get end of list
        while(end-- != 0) temp = temp.next;
        //breaking last node link and pointing too null
        head = temp.next;
        temp.next = null;
        return head;

    }


}
