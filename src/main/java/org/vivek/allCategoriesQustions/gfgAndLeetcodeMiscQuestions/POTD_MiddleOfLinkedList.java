// https://www.geeksforgeeks.org/problems/finding-middle-element-in-a-linked-list/1
class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}

public class POTD_MiddleOfLinkedList
{
    int getMiddle(Node head){
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
}
