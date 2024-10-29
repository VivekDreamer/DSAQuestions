// https://www.geeksforgeeks.org/problems/count-nodes-of-linked-list/1
public class POTD_QuickSortOnLinkedList{
    public static Node quickSort(Node head){
        if(head==null || head.next==null)
            return head;
        Node tail=head;
        while (tail.next!=null){
            tail=tail.next;
        }
        solve(head,tail);
        return head;
    }
    public static void solve(Node head,Node tail){
        if(head==null || head==tail)
            return;
        Node part=partition(head,tail);
        solve(head,part);
        solve(part.next,tail);
    }
    public static Node partition(Node head,Node tail){
        Node prev=head;
        Node curr=head.next;
        Node pivot=head;
        while (curr!=null){
            if(pivot.data>curr.data){
                int temp=prev.next.data;
                prev.next.data=curr.data;
                curr.data=temp;
                prev=prev.next;
            }
            curr=curr.next;
        }
        int temp=pivot.data;
        pivot.data=prev.data;
        prev.data=temp;
        return prev;
    } 
}
