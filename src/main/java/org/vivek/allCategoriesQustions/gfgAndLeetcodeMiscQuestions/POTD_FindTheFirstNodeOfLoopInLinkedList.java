// https://www.geeksforgeeks.org/problems/find-the-first-node-of-loop-in-linked-list--170645/1
class Node{
    int data;
    Node next;
    Node(int x){
        data = x;
        next = null;
    }
}

public class POTD_FindTheFirstNodeOfLoopInLinkedList {
    public static Node findFirstNode(Node head) {
        if(head==null||head.next==null){
            return null;
        }
        Node slow=head;
        Node fast=head;
        Node ans=new Node(-1);
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        if(fast==slow){
            slow=head;
            while(slow!=fast){
            slow= slow.next;
            fast=fast.next;
        }
        return slow;
        }
    }
    return ans;
    }
}
