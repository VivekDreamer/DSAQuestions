// https://www.geeksforgeeks.org/problems/count-nodes-of-linked-list/1
class POTD_CountLinkedListNodes {
    public int getCount(Node head) {
        Node temp = head;
        int count = 0;
        while(temp != null){
            temp = temp.next;
            count++;
            
        }
        return count;
    }
}
