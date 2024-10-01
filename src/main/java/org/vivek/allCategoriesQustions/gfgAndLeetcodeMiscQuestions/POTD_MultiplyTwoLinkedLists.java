// https://www.geeksforgeeks.org/problems/multiply-two-linked-lists/1
class POTD_MultiplyTwoLinkedLists {
    public long multiplyTwoLists(Node first, Node second) {
        Node temp = first;
        String str = new String();
        
        while (temp != null){
            int num = temp.data;
            str += (num+"");
            temp= temp.next;
        }
        
        long number1 = Long.parseLong(str);
        
        temp = second;
        str = new String();
        while (temp != null){
            int num = temp.data;
            str += (num+"");
            temp= temp.next;
        }
        
        long number2 = Long.parseLong(str);
        
        
        long mod = 1000000007L;
        
        return ((number1%mod)*(number2%mod))%mod;
    }
}
