package org.vivek.linkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    static class Node{
        Node prev, next;
        int key, value;
        Node(int _key, int _value){
            this.key = _key;
            this.value = _value;
        }
    }

    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    Map<Integer,Node> map = new HashMap<>(); //cache
    int capacity;  //capacity of cache

    public LRUCache(int _capacity){
        this.capacity = _capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        if(map.containsKey(key)){  //first check in the cache
            Node node = map.get(key); //take the value of node 
            remove(node);  //remove from the current position
            insert(node);  //insert it right after the head
            return node.value;
        }else{
            return -1;
        }
    }

    public void put(int key, int value){
        //if map contains the key then, remove it
        if(map.containsKey(key)) remove(map.get(key));
        if(map.size() == capacity) remove(tail.prev);
        insert(new Node(key,value));
    }

    public void remove(Node node){
        map.remove(node.key);  //first remove from cache
        //updates the pointer of doubly linked list
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insert(Node node){
        //first put the value in cache
        map.put(node.key, node);
        //update the pointers
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;
    }
}
