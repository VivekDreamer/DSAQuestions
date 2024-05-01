// https://www.geeksforgeeks.org/problems/arrange-consonants-and-vowels/1
class Node {
    char data;
    Node next;
    
    public Node(char data){
        this.data = data;
        next = null;
    }
}
public class POTD_ArrangeConsonantsAndVowels {
   
    public Node arrangeCV(Node head){
        Node constDummy = new Node('#');
        Node vowelDummy = new Node('#');
        Node constTail = constDummy;
        Node vowelTail = vowelDummy;
        Node curr = head;
        while(curr != null){
            if(!isVowel(curr.data)){
                constTail.next = new Node(curr.data);
                constTail = constTail.next;
            }else{
                vowelTail.next = new Node(curr.data);
                vowelTail = vowelTail.next;
            }
            curr = curr.next;
        }
        vowelTail.next = constDummy.next;
        Node ansHead = vowelDummy.next;
        return ansHead;
    }
    public boolean isVowel(char ch){
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }
}
