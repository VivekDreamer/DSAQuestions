// https://www.geeksforgeeks.org/problems/rotate-a-linked-list/1
class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}
public class Solution {
    // Function to rotate a linked list.
    public Node rotate(Node head, int k) {
        Node h1=null;
        Node ptr=head;
        while(ptr!=null){
            k--;
            if(k==0){
               h1=ptr.next;
               ptr.next=null;
               ptr=h1;
               continue;
            } else if(ptr.next==null){
                ptr.next=head;
                break;
            }
            ptr=ptr.next;
        }
        return h1!=null?h1:head;
    }
}
