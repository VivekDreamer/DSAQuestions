// https://www.geeksforgeeks.org/problems/linked-list-length-even-or-odd/1
public class POTD_IsLinkedListLengthEven {
    public boolean isLengthEven(Node head) {
        int length = 0;
        while(head != null){
            length += 1;
            head = head.next;
        }
        return (length % 2) == 0;
    }
}
