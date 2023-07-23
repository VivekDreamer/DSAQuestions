package org.vivek.heap;

import java.util.ArrayList;
import java.util.PriorityQueue;
// Given an array of N elements, where each element is at most K away from its target position, devise an algorithm that sorts in O(N log K) time.
public class NearlySorted {
    public static void main(String[] args) {
        int k = 3; 
        int arr[] = { 2, 6, 3, 12, 56, 8 }; 
        int n = arr.length; 
        ArrayList<Integer> nearlySorted = nearlySorted(arr, n, k);
        System.out.println(nearlySorted);

    }
    static ArrayList <Integer> nearlySorted(int arr[], int num, int k){
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 
        for(int i = 0; i < k+1; i++){
            pq.add(arr[i]);
        }
        for(int i = k+1; i<arr.length; i++){
            list.add(pq.peek());
            pq.poll();
            pq.add(arr[i]);
        }
        while(pq.isEmpty()==false){
            list.add(pq.poll());
        }
        return list;
    }

}
