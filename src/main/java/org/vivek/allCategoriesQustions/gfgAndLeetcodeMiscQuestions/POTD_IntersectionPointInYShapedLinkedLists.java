// https://www.geeksforgeeks.org/problems/intersection-point-in-y-shapped-linked-lists/1
class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
public class POTD_IntersectionPointInYShapedLinkedLists {
    int lengthOfLinkedList(Node head) {
        int length = 0;
        while(head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
    // Function to find intersection point in Y shaped Linked Lists.
    int intersectPoint(Node head1, Node head2) {
        int length1 = lengthOfLinkedList(head1);
        int length2 = lengthOfLinkedList(head2);
        while(length1 > length2) {
            head1 = head1.next;
            length1--;
        }
        while(length2 > length1) {
            head2 = head2.next;
            length2--;
        }
        while(head1 != null && head2 != null) {
            if(head1 == head2) return head1.data;
            head1 = head1.next;
            head2 = head2.next;
        }
        return -1;
    }
}
