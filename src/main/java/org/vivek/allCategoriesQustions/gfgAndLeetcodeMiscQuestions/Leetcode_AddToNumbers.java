public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        ListNode first = l1;
        ListNode second = l2;
        int carry = 0;
        while(first != null || second != null){
            int a = first != null ? first.val : 0;
            int b = second != null ? second.val : 0;
            int sum = a + b + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if(first != null) first = first.next;
            if(second != null) second = second.next;
        }
        if(carry > 0){
            current.next = new ListNode(carry);
        }
        return dummy.next;
    }
  static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
