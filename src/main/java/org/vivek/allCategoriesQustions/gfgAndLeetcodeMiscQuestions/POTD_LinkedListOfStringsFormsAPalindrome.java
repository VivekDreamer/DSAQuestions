// https://www.geeksforgeeks.org/problems/linked-list-of-strings-forms-a-palindrome/1
class POTD_LinkedListOfStringsFormsAPalindrome {
    public boolean compute(Node root) {
        StringBuilder sb = new StringBuilder();
        Node temp = root;
        while(temp != null){
            sb.append(temp.data);
            temp = temp.next;
        }
        return isPalindrome(sb);
    }
    public boolean isPalindrome(StringBuilder sb){
        int i = 0, j = sb.length()-1;
        while(i <= j){
            if(sb.charAt(i) != sb.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
