// https://www.geeksforgeeks.org/problems/find-the-sum-of-last-n-nodes-of-the-linked-list/1
class Node {
    int data;
    Node next;

    public Node (int data){
        this.data = data;
        this.next = null;
    }
}

public class POTD_FindTheSumOfLastNNodesOfTheLinkedList {

    // Return the sum of last k nodes
    public int sumOfLastN_Nodes(Node head, int n) {
        int len = n;
        Node temp = head;
        int sum=0;
        while(len > 0){
            sum += temp.data;
            temp = temp.next;
            len--;
        }
        Node prev = head;
        while(temp != null){
            sum += temp.data;
            sum -= prev.data;
            temp = temp.next;
            prev = prev.next;
        }
        return sum;
    }
}
