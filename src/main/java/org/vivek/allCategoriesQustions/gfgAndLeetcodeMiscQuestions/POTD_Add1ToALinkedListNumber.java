// https://www.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

public class POTD_Add1ToALinkedListNumber {
    public Node addOne(Node head) {
        if(head.next == null){   // step 1
            head.data+= 1;  // Add 1 to the last node
		    return head;
	    }
	    Node sum = addOne(head.next);   // step 2
	    head.data+= (sum.data/10);   // step 3
	    sum.data = sum.data%10;   // step 4
	    return head;   // step 5
    }
}
