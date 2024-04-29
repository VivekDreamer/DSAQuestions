// https://www.geeksforgeeks.org/problems/remove-every-kth-node/1
class Node
{
	Node next;
	int data;
	Node(int d)
	{
		data = d;
		next = null;
	}
}
public class POTD_RemoveEverykthNode
{
    /*You are required to complete this method*/
    Node delete(Node head, int k){
        Node prevNode = new Node(-1);
        Node tempNode = prevNode;
        prevNode.next = head;
        int count = 1;
        while(tempNode.next != null){
            if(count == k){
                tempNode.next = tempNode.next.next;
                count = 0;
            }else{
                tempNode = tempNode.next;
            }
            count++;
        }
        return prevNode.next;
    }
}
