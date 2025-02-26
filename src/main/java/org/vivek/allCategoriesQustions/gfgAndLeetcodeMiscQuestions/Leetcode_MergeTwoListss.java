class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Leetcode_MergeTwoListss {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if( list1 == null || list2 == null)
            return list2 != null ? list2 : list1;
        
        ListNode firstList = list1;
        ListNode secondList = list2;
        ListNode answer = new ListNode(0);
        ListNode previous = answer;
        
        while(firstList != null && secondList != null){
            if(firstList.val < secondList.val){
                previous.next = firstList;
                firstList = firstList.next;
            }
            else{
                previous.next = secondList;
                secondList = secondList.next;
            }
            previous = previous.next;
        }
        
        previous.next = firstList != null ? firstList : secondList;
        return answer.next;
    }
}
