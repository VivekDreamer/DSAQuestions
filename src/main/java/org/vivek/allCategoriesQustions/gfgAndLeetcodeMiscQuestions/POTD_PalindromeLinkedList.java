https://www.geeksforgeeks.org/problems/check-if-linked-list-is-pallindrome/1
public class POTD_PalindromeLinkedList {
    // Function to check whether the list is palindrome.
    Node reverse(Node head){
        Node curr = head;
        Node prev = null;
        while(curr != null){
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    boolean isPalindrome(Node head) {
        // Your code here
        Node curr = head;
        Node tail = reverse(head);
        while(curr != null){
            if(curr.data != tail.data){
                return false;
            }
            curr = curr.next;
            tail = tail.next;
        }
        return true;
    }
}
