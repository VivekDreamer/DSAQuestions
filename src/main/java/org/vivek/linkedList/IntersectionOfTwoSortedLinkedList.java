package org.vivek.linkedList;

//https://www.geeksforgeeks.org/problems/intersection-of-two-sorted-linked-lists/1
public class IntersectionOfTwoSortedLinkedList {
    public static Node findIntersection(Node head1, Node head2){
        Node new_node = new Node(-1);
        Node temp = new_node;
         while(head1 != null && head2 != null){
             if(head1.data == head2.data){
                 int a = head1.data;
                 temp.next = new Node(a);
                 temp = temp.next;
                 head1 = head1.next;
                 head2 = head2.next;
             }else if(head1.data < head2.data){
                 head1 = head1.next;
             }else{
                 head2 = head2.next;
             }
         }
         return new_node.next;
     }
     static class Node {
        int data;
         Node next;
         Node(int d)  { data = d;  next = null; }
     }
}
