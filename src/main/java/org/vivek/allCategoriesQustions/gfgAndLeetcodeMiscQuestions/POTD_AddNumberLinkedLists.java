// https://www.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class POTD_AddNumberLinkedLists {
    static Node addTwoLists(Node first, Node second) {
        first = reverseList(first);
        second = reverseList(second);
        int carry = 0;
        Node dummy = new Node(-1);
        Node temp = dummy;
        while(first != null || second != null || carry == 1){
            int a = (first != null) ? first.data : 0;
            int b = (second != null) ? second.data : 0;
            int sum = a + b + carry;
            temp.next = new Node(sum % 10);
            temp = temp.next;
            carry = sum / 10;
            if(first != null) first = first.next;
            if(second != null) second = second.next;
        }
        Node ans = reverseList(dummy.next);
        while(ans != null && ans.data == 0) ans = ans.next;
        return (ans==null) ? new Node(0) : ans;
    }
    static Node reverseList(Node head){
        if(head == null || head.next == null) return head;
        Node prev = null, curr = head, next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
