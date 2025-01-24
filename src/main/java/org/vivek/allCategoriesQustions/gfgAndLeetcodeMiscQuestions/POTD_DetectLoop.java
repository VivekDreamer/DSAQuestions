class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

public class POTD_DetectLoop {
    public static boolean detectLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while(slow!=null && fast !=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
            return true;
        }
        return false;
    }
}
