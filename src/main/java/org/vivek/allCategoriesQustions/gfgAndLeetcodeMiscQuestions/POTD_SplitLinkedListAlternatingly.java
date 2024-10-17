// https://www.geeksforgeeks.org/problems/split-singly-linked-list-alternatingly/1
class Node{
    int data;
    struct Node* next;
    Node(int x){
        data = x;
        next = NULL;
    }
}

public class POTD_SplitLinkedListAlternatingly {
    // Function to append a new node with newData at the end of a linked list
    Node[] alternatingSplitList(Node head) {
        Node temp1=head;
        Node first=head;
        Node temp2=head.next;
        Node second=temp2;
        while(temp2!=null){
            temp1.next=temp2.next;
            temp1=temp2;
            temp2=temp2.next;
        }
        return new Node[]{first,second};
    }
}
