// https://www.geeksforgeeks.org/problems/merge-sort-on-doubly-linked-list/1
class Node
{
    int data;
    Node next, prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}
public class POTD_MergeSortInDoublyLinkedList {
    // Function to sort the given doubly linked list using Merge Sort.
    static Node sortDoubly(Node head) {
        if(head == null || head.next == null) return head;
        //storing middle by calling split function
        Node left = head;
        Node right = splitList(head);
        //recursion for further spliting the list
        left = sortDoubly(left);
        right = sortDoubly(right);
        //calling merge function to sort and merge
        Node result = merge(left,right);
        return result;
    }
    //split function to find middle
    static Node splitList(Node head){
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node temp = slow.next;
        slow.next = null;
        temp.prev = null;
        return temp;
    }
    //merge function to perform sort and merge
    static Node merge(Node left, Node right){
        if(left == null) return right;
        if(right == null) return left;
        Node head = new Node(0);
        Node tail = head;
        Node temp = null;
        while(left != null && right != null){
            if(left.data <= right.data){
                tail.next = left;
                temp = tail;
                tail = tail.next;
                tail.prev = temp;
                left = left.next;
            }else{
                tail.next = right;
                temp = tail;
                tail = tail.next;
                tail.prev = temp;
                right = right.next;
            }
        }
        if(left == null){
            tail.next = right;
            temp = tail;
            tail = tail.next;
            tail.prev = temp;
        }
        if(right == null){
            tail.next = left;
            temp = tail;
            tail = tail.next;
            tail.prev = temp;
        }
        head = head.next;
        head.prev = null;
        return head;
    }
}
