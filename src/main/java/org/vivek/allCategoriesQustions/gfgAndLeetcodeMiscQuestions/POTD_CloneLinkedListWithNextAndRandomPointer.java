// https://www.geeksforgeeks.org/problems/clone-a-linked-list-with-next-and-random-pointer/1
/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

class Node {
    int data;
    Node next, arb;

    Node(int d) 
    { 
        data = d;
        next = arb = null; 
        
    }
}

public class POTD_CloneLinkedListWithNextAndRandomPointer {
    //Function to clone a linked list with next and random pointer.
    /*Node copyList(Node head) {
        if(head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        Node prev = null;
        Node newHead = null;
        
        while(curr != null){
            Node temp = new Node(curr.data);
            map.put(curr,temp);
            if(newHead == null){
                newHead = temp;
                prev = newHead;
            }
            else{
                prev.next = temp;
                prev = temp;
            }
            curr = curr.next;
        }
        
        //fill random pointers
        curr = head;
        Node newCurr = newHead;
        while(curr != null){
            if(curr.arb == null){
                newCurr.arb = null;
            }else{
                newCurr.arb = map.get(curr.arb);
            }
            curr = curr.next;
            newCurr = newCurr.next;
        }
        return newHead;
    }*/

    Node copyList(Node head){
        if(head == null) return null;
        //insert the new nodes in between the original list
        Node curr = head;
        while(curr != null){
            Node currNext = curr.next;
            curr.next = new Node(curr.data);
            curr.next.next = currNext;
            curr = currNext;
        }
        //deep copy of random pointers
        curr = head;
        while(curr != null){
            if(curr.arb == null){
                curr.next.arb = null;
            } else{
                curr.next.arb = curr.arb.next;
            }
            curr = curr.next.next;
        }
        
        //seperate the linked list
        Node newHead = head.next;
        Node newCurr = newHead;
        curr = head;
        while(curr != null && newCurr != null){
            curr.next = curr.next == null ? null : curr.next.next;
            newCurr.next = newCurr.next == null ? null : newCurr.next.next;
            curr = curr.next;
            newCurr = newCurr.next;
        }
        return newHead;
    }
}

