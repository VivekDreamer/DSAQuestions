// https://www.geeksforgeeks.org/problems/xor-linked-list/1
class Node {
    int data;
    Node npx;

    Node(int x) {
        data = x;
        npx = null;
    }
}
public class POTD_XORLinkedList {
    static Node insert(Node head, int data) {
        Node x=new Node(data);
        x.npx=head;
        return x;
    }
  
    static ArrayList<Integer> getList(Node head) {
        ArrayList<Integer> l1=new ArrayList<>();
        Node x=head;
        while(x!=null){
            l1.add(x.data);
            x=x.npx;
        }
        return l1;
    }
}
