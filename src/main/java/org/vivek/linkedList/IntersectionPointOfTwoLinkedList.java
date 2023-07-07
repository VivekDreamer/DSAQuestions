package org.vivek.linkedList;

import java.util.HashSet;
import java.util.Set;

public class IntersectionPointOfTwoLinkedList {

    public static void main(String[] args) {
        ListNode head = null;
        head = insert(head, 1);
        head = insert(head, 3);
        head = insert(head, 1);
        head = insert(head, 2);
        head = insert(head, 4);
        ListNode head1 = head;
        head = head.next.next.next;
        ListNode headSec = null;
        headSec = insert(headSec, 3);
        ListNode head2 = headSec;
        headSec.next = head;
        //printing of the lists
        System.out.print("List1: "); printList(head1);
        System.out.print("List2: "); printList(head2);
        //checking if intersection is present
        ListNode answerNode = intersectionPresent(head1,head2);
        if(answerNode == null) System.out.println("No intersection\n");
        else System.out.println("The intersection point is "+answerNode.val);
        
        ListNode intersectionPresentDiffInLength = intersectionPresentDiffInLength(head1, head2);
        if(intersectionPresentDiffInLength == null) System.out.println("No intersection\n");
        else System.out.println("The intersection point is "+answerNode.val);

        ListNode intersectionPresentHashing = intersectionPresentHashing(head1, head2);
        if(intersectionPresentHashing == null)  System.out.println("No intersection\n");
        else System.out.println("The intersection point is "+answerNode.val);
    
        ListNode intersectionPresentOptimized = intersectionPresentOptimized(head1, head2);
        if(intersectionPresentOptimized == null) System.out.println("No intersection\n");
        else System.out.println("The intersection point is "+answerNode.val);
    }

    static ListNode insert(ListNode head , int val){
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
    
    //brute force
    //1. Keep any one of the list to check its node present in the other list. Here, we are choosing the second list for this task.
    //2. Iterate through the other list. Here, it is the first one.
    //3. Check if the both nodes are the same. If yes, we got our first intersection node.
    //4. If not, continue iteration.
    //5. If we did not find an intersection node and completed the entire iteration of the second list, then there is no intersection between the provided lists. Hence, return null.
    static ListNode intersectionPresent(ListNode head1, ListNode head2){
        while(head2 != null){
            ListNode temp = head1;
            while(temp != null){
                //if both nodes are same
                if(temp == head2) return head2;
                temp = temp.next;
            }
            head2 = head2.next;
        }
        //intersection not present between the list, return null
        return null;
    }

    static void printList(ListNode head){
        while(head.next != null){
            System.out.print(head.val+"->");
            head = head.next;
        }
        System.out.println(head.val);
    }

    //Iterate through list 1 and hash its node address.
    //Iterate through list 2 and search the hashed value in the hash table. If found, return node.
    static ListNode intersectionPresentHashing(ListNode head1, ListNode head2){
        Set<ListNode> set = new HashSet<>();
        while(head1 != null){
            set.add(head1);
            head1 = head1.next;
        }
        while(head2 != null){
            if(set.contains(head2)) return head2;
            head2 = head2.next;
        }
        return null;
    }
    
    //Difference in length
    //1. Find the length of both lists.
    //2. Find the positive difference between these lengths.
    //3. Move the dummy pointer of the larger list by the difference achieved. This makes our search length reduced to a smaller list length.
    //4. Move both pointers, each pointing two lists, ahead simultaneously if both do not collide.
    static ListNode intersectionPresentDiffInLength(ListNode head1, ListNode head2){
        int diff = getDifference(head1, head2);
        if(diff < 0) 
            while(diff++ != 0) head2 = head2.next;
        else
            while(diff-- != 0) head1 = head1.next;
        while(head1 != null){
            if(head1 == head2) return head1;
            head2 = head2.next;
            head1 = head1.next;
        }
        return head1;
    }

    static int getDifference(ListNode head1, ListNode head2){
        int len1 = 0, len2 = 0;
        while(head1 != null || head2 != null){
            if(head1 != null){
                ++len1;
                head1 = head1.next;
            }
            if(head2 != null){
                ++len2;
                head2 = head2.next;
            }
        }
        return len1 - len2; // if difference is negative then, length of list2 > length of list1 else vice-versa
    }

    //Optimized
    //1. Take two dummy nodes for each list. Point each to the head of the lists.
    //2. Iterate over them. If anyone becomes null, point them to the head of the opposite lists and continue iterating until they collide.
    static ListNode intersectionPresentOptimized(ListNode head1, ListNode head2){
        ListNode dummy1 = head1;
        ListNode dummy2 = head2;
        while(dummy1 != dummy2){
            dummy1 = (dummy1 == null) ? head2 : dummy1.next;
            dummy2 = (dummy2 == null) ? head1 : dummy2.next;
        }
        return dummy1;
    }
}
