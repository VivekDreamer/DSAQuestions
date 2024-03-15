package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

import java.util.ArrayList;
import java.util.Collections;

public class POTD_LinkedListThatIsSortedAlternatingly {
    /*
   public Node sort(Node head){
        Node h1 = new Node(-1);
        Node h2 = new Node(-1);
        Node ch1 = h1, ch2= h2;
        Node curr = head;
        while(curr != null){
            ch1.next = curr;
            ch1 = ch1.next;
            curr = curr.next;
            if(curr != null){
                ch2.next = curr;
                ch2 = ch2.next;
                curr = curr.next;
            }
            ch1.next = null;
            ch2.next = null;
        }
        h1 = h1.next; h2 = h2.next;
        h2 = reverseList(h2);
        return merge(h1, h2);
   }
   
   public Node reverseList(Node head){
       Node current = head;
       Node prev = null;
       Node next;
       while(current != null){
           next = current.next;
           current.next = prev;
           prev = current;
           current = next;
       }
       return prev;
   }
   
   public Node merge(Node r1, Node r2){
       Node dummy = new Node(-1);
       Node current = dummy;
       while(r1 != null && r2 != null){
           if(r1.data < r2.data){
               current.next = r1;
               r1 = r1.next;
           }else{
               current.next = r2;
               r2 = r2.next;
           }
           current = current.next;
       }
       if(r1 != null) current.next = r1;
       else current.next = r2;
       return dummy.next;
   }
   */
   
   public Node sort(Node head){
        ArrayList<Integer> values = new ArrayList<>();
        Node temp = head;
        while (temp != null) {
            values.add(temp.data);
            temp = temp.next;
        }
        Collections.sort(values);
        temp = head;
        int i = 0;
        while (temp != null) {
            temp.data = values.get(i++);
            temp = temp.next;
        }
        return head;
   }
   class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}
}
