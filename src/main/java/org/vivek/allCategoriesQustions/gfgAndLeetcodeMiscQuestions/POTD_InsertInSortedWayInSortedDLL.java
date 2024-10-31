// https://www.geeksforgeeks.org/problems/insert-in-sorted-way-in-a-sorted-dll/1
class Node {
    int data;
    Node prev, next;
    Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}
public class POTD_InsertInSortedWayInSortedDLL {
    public Node sortedInsert(Node head, int x) {
        Node prev=null,temp=head;
        while(temp!=null && temp.data<x){
            prev=temp;
            temp=temp.next;
        }
        if(prev==null){
            prev=new Node(x);
            prev.next=head;       //case 1 when x need to be in first position
            head.prev=prev;
            return prev;
        }
        else if(temp==null){
            Node a=new Node(x);     //case 2 when x need to be in last position
            prev.next=a;
            a.prev=prev;
            return head;
        }
        Node a=new Node(x);
        a.next=prev.next;          //case 3 when x need to be in between first and last position
        prev.next.prev=a;
        prev.next=a;
        a.prev=prev;
        return head;
    }
}
