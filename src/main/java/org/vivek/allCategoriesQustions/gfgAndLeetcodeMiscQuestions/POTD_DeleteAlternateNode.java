// https://www.geeksforgeeks.org/problems/delete-alternate-nodes/1
class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
    }
}

public class POTD_DeleteAlternateNode {
    public void deleteAlt(Node head) {
        while (head != null && head.next != null){
            head.next = head.next.next;
            head = head.next;
        }
    }
}
