package org.vivek.linkedList;

import java.util.HashMap;

class NodeList{
    int val;
    NodeList next;
    NodeList random;
    NodeList(int value){
        this.val = value;
        this.next = null;
        this.random = null;
    }
}
public class CloneLinkedList {
    public static void main(String[] args) {
        NodeList head = null;
        NodeList NodeList1 = new NodeList(1);
        NodeList NodeList2 = new NodeList(2);
        NodeList NodeList3 = new NodeList(3);
        NodeList NodeList4 = new NodeList(4);

        head = NodeList1;
        head.next = NodeList2;
        head.next.next = NodeList3;
        head.next.next.next = NodeList4;

        head.random = NodeList4;
        head.next.random = NodeList1;
        head.next.next.random = null;
        head.next.next.next.random = NodeList2;

        System.out.println("original list: (current NodeList : NodeList pointed by next pointer, NodeList pointed by random pointer)");
        printList(head);

        System.out.println("copy list: (current NodeList : NodeList pointed by next pointer, NodeList pointed by random pointer)");
        NodeList newHead = copyRandomList(head);
        printList(newHead);
    }

//     Iterate through the entire list.
//     For each nodeList, create a deep copy of each nodeList and hash it with it. Store it in the hashmap.
//     Now, again iterate through the given list. For each nodeList, link the deep nodeList present as the hash value of the original nodeList as per original nodeList. 
//     the head of the deep copy list will be the head of hashed value of original nodeList.

    public static NodeList copyRandomList(NodeList head){
        HashMap<NodeList,NodeList> map = new HashMap<>();
        NodeList temp = head;
        //first iteration for insrting copy NodeLists of every NodeList in the hashmap
        while(temp != null){
            NodeList newNodeList = new NodeList(temp.val);
            map.put(temp, newNodeList);
            temp = temp.next;
        }
        NodeList t = head;
        //second iteration for linking next and random pointers as given
        while(t != null){
            NodeList NodeList = map.get(t);
            NodeList.next = (t.next != null) ? map.get(t.next):null;
            NodeList.random = (t.random != null) ? map.get(t.random):null;
            t = t.next;
        }
        return map.get(head);
    }

    public static void printList(NodeList head){
        while(head != null){
            System.out.print(head.val + ":");
            if(head.next != null) System.out.print(head.next.val);
            else System.out.print("NULL");
            if(head.random != null) System.out.println(","+head.random.val);
            else System.out.print(",NULL");
            System.out.println();
            head = head.next;
        }
    }

    // Create deep nodes of all nodes. Instead of storing these nodes in a hashmap, we will point it to the next of the original nodes.
    // Take a pointer, say itr, point it to the head of the list. This will help us to point random pointers as per the original list. This can be achieved by itr->next->random = itr->random->next
    // Use three pointers. One dummy node whose next node points to the first deep node. itr pointer at the head of the original list and fast which is two steps ahead of the itr. This will be used to separate the original linked list with the deep nodes list.
    public static NodeList copyRandomListOptimised(NodeList head) {
        NodeList temp = head;
        //step 1
        while(temp != null) {
            NodeList newNodeList = new NodeList(temp.val);
            newNodeList.next = temp.next;
            temp.next = newNodeList;
            temp = temp.next.next;
        }
        //step 2
        NodeList itr = head;
        while(itr != null) {
            if(itr.random != null)
                itr.next.random = itr.random.next;
            itr = itr.next.next;
        }
        //step 3
        NodeList dummy = new NodeList(0);
        itr = head;
        temp = dummy;
        NodeList fast;
        while(itr != null) {
            fast = itr.next.next;
            temp.next = itr.next;
            itr.next = fast;
            temp = temp.next;
            itr = fast;
        }
        return dummy.next;
    }
}
