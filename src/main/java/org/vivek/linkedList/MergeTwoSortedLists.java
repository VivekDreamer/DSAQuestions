package org.vivek.linkedList;

public class MergeTwoSortedLists {
    // Inplace method without using extra space
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        //iterative
        // when list1 is empty then 
        // our output will be same as list2
        if(l1 == null) return l2;

        // when list2 is empty then our output 
        // will be same as list1
        if(l2 == null) return l1;

        // pointing l1 and l2 to smallest and greatest one respectively
        if(l1.val > l2.val){
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        // act as head of resultant merged list
        ListNode res = l1;
        while(l1 != null && l2 != null){
            ListNode tmp = null;
            while(l1 != null && l1.val <= l2.val){
                tmp = l1;  //storing last sorted node
                l1 = l1.next;
            }
            // link previous sorted node with 
            // next larger node in list2
            tmp.next = l2;
            //swap 
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        return res;
    }

    public ListNode mergeTwoListsExtraSpace(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                current.next = l1;
                l1 = l1.next;
            }else{
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Insert the remaining nodes from l1 or l2, if any
        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }

        return dummy.next; // Return the head of the merged list
    }
}
