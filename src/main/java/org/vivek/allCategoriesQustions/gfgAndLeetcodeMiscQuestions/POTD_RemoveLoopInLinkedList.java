// https://www.geeksforgeeks.org/problems/remove-loop-in-linked-list/1
class Node
{
    int data;
    Node next;
}

public class POTD_RemoveLoopInLinkedList {
    public static void removeLoop(Node head) {
        Node slow = head;
        Node fast = head;
        
        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                Node last = slow;
                
                while(last.next != fast){
                    last = last.next;
                }
                last.next = null;
            }
        }
    }
}
