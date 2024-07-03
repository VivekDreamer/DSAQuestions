// https://www.geeksforgeeks.org/problems/remove-all-occurences-of-duplicates-in-a-linked-list/1
class POTD_RemoveAllOccurencesOfDuplicatesInALinkedList {
    public Node removeAllDuplicates(Node head) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;
        Node curr = head;
        while(curr != null){
            boolean hasDuplicates = false;
            while(curr.next != null && curr.data == curr.next.data){
                hasDuplicates = true;
                curr = curr.next;
            }
            if(hasDuplicates){
                //skip all the duplicate
                prev.next = curr.next;
            }else{
                //move prev to next node if no duplicate is found
                prev = prev.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
