package org.vivek.linkedList;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    //representing the node structure in double linked list
    static class DLLNode{
        int key;
        int val;
        int frequency;
        DLLNode prev;
        DLLNode next;

        public DLLNode(int key, int val){
            this.key = key;
            this.val = val;
            this.frequency = 1;
        }
    }

    //representing the doubly linked list
    //having head, tail, listSize
    //defined common method like addNode, removeNode
    static class DoubleLinkedList{
        int listSize;
        DLLNode head;
        DLLNode tail;
        public DoubleLinkedList() {
            this.listSize = 0;
            this.head = new DLLNode(0, 0);
            this.tail = new DLLNode(0, 0);
            head.next = tail;
            tail.prev = head;
        }
        /** add new node into head of list and increase the list size by 1 */
        public void addNode(DLLNode currNode){
            DLLNode nextNode = head.next;
            currNode.next = nextNode;
            nextNode.prev = currNode;
            head.next = currNode;
            currNode.prev = head;
            listSize++;
        }

        /** remove input node and decrease the size by 1 */
        public void removeNode(DLLNode currNode){
            DLLNode prevNode = currNode.prev;
            DLLNode nextNode = currNode.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            listSize--;
        }
        
    }

    final int capacity;
    int curSize;
    int minFrequency;
    Map<Integer,DLLNode> cache;
    Map<Integer,DoubleLinkedList> frequencyMap;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.curSize = 0;
        this.minFrequency = 0;
        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }

    /** get node value by key, and then update node frequency as well as relocate that node **/
    public int get(int key){
        DLLNode currNode = cache.get(key);
        if(currNode == null) return -1;
        updateNode(currNode);
        return currNode.val;
    }

    private void updateNode(DLLNode currNode) {
        int currFreq = currNode.frequency;
        DoubleLinkedList currList = frequencyMap.get(currFreq);
        currList.removeNode(currNode);
        //if current list is the last list which has lower frequency and current node is the only node 
        //in that list, then, we need to remove the entire list and then increase the min freq value by 1
        if(currFreq == minFrequency && currList.listSize == 0) minFrequency++;
        currNode.frequency++;
        // add current node to another list has current frequency + 1,
        // if we do not have the list with this frequency, initialize it
        DoubleLinkedList newList = frequencyMap.getOrDefault(currNode.frequency, new DoubleLinkedList());
        newList.addNode(currNode);
        frequencyMap.put(currNode.frequency, newList);
    }
    
    /**
     * add new node into LFU cache, as well as double linked list
     * condition 1: if LFU cache has input key, update node value and node position in list
     * condition 2: if LFU cache does NOT have input key
     *  - sub condition 1: if LFU cache does NOT have enough space, remove the Least Recent Used node
     *  in minimum frequency list, then add new node
     *  - sub condition 2: if LFU cache has enough space, add new node directly
     * **/
    public void put(int key, int value) {
        // corner case: check cache capacity initialization
        if (capacity == 0) {
            return;
        }

        if (cache.containsKey(key)) {
            DLLNode curNode = cache.get(key);
            curNode.val = value;
            updateNode(curNode);
        }
        else {
            curSize++;
            if (curSize > capacity) {
                // get minimum frequency list
                DoubleLinkedList minFreqList = frequencyMap.get(minFrequency);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                curSize--;
            }
            // reset min frequency to 1 because of adding new node
            minFrequency = 1;
            DLLNode newNode = new DLLNode(key, value);

            // get the list with frequency 1, and then add new node into the list, as well as into LFU cache
            DoubleLinkedList curList = frequencyMap.getOrDefault(1, new DoubleLinkedList());
            curList.addNode(newNode);
            frequencyMap.put(1, curList);
            cache.put(key, newNode);
        }
    }
}
