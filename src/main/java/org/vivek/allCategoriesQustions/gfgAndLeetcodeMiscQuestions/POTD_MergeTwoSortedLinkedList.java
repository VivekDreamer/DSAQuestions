// https://www.geeksforgeeks.org/problems/merge-two-sorted-linked-lists/1
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}
public class POTD_MergeTwoSortedLinkedList {
    Node sortedMerge(Node head1, Node head2) {
        Node temp1=head1;
        Node temp2=head2;
        Node dummyNode = new Node(-1);
        Node sort=dummyNode;
        while(temp1!=null && temp2!=null){
            if(temp1.data<temp2.data){
                sort.next=temp1;
                sort=temp1;
                temp1=temp1.next;
            
            }
            else{
                 sort.next=temp2;
                sort=temp2;
                temp2=temp2.next;
            }
        }
       if(temp1!=null){
           sort.next=temp1;
       }
       else{
           sort.next=temp2;
       }
        
        return dummyNode.next;
    }
}
