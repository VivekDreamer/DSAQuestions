// https://www.geeksforgeeks.org/problems/clone-a-linked-list-with-next-and-random-pointer/1
class Node {
    int data;
    Node next;
    Node random;

    Node(int x) {
        data = x;
        next = null;
        random = null;
    }
}

public class POTD_CloneListWithNextAndRandom {
    public Node cloneLinkedList(Node head) {
        Node tmp = head;
        while(tmp != null){
            Node cpy = new Node(tmp.data);
            cpy.next = tmp.next;
            tmp.next = cpy;
            tmp = cpy.next;
        }
        
        tmp = head;
        while(tmp != null){
            if(tmp.random != null){
                tmp.next.random = tmp.random.next;
            }
            tmp = tmp.next.next;
        }
        
        tmp = head;
        Node copy = head.next;
        Node copyPtr = copy;
        
        while(tmp != null){
            tmp.next = tmp.next.next;
            tmp = tmp.next;
            if(tmp!=null){
                copyPtr.next = tmp.next;
                copyPtr = copyPtr.next; 
            }
        }
        
        return copy;
    }
}
