// https://www.geeksforgeeks.org/problems/delete-middle-of-linked-list/1
class Node {
    int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}

public class POTD_DeleteMiddleOfLinkedList {
    Node deleteMid(Node head) {
        if(head == null || head.next == null) return null;
        Node slow = head, fast = head, prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
    }
}
