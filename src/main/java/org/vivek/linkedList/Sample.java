package org.vivek.linkedList;

public class Sample {
    // 1 2 3 4 6
    // 2 4 6 8
    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(6);
        
        Node head2 = new Node(2);
        head2.next = new Node(4);
        head2.next.next = new Node(6);
        head2.next.next.next = new Node(8);

        Node findIntersection = findIntersection(head1, head2);
    }
    public static Node findIntersection(Node head1, Node head2){
        Node head = null;
         while(head1 != null && head2 != null){
             if(head1.data == head2.data){
                 if(head == null)
                     head = new Node(head1.data);
                 else{
                     head.next = new Node(head1.data);
                 }
                 head1 = head1.next;
                 head2 = head2.next;
             }else if(head1.data < head2.data){
                 head1 = head1.next;
             }else{
                 head2 = head2.next;
             }
         }
         return head;
     }
     static class Node {
        int data;
         Node next;
         Node(int d)  { data = d;  next = null; }
     }
}
