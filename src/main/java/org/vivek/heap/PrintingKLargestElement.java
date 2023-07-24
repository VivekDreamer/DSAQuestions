package org.vivek.heap;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PrintingKLargestElement {
    public static void main(String[] args) {
        int arr[] = { 11, 3, 2, 1, 15, 5, 4, 45, 88, 96, 50, 45 };
	    int k = 3;
	    firstKElements(arr, k);
    }
    public static void firstKElements(int[] arr, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < k; i++){
            minHeap.add(arr[i]);
        }
        for(int i = k; i < arr.length; i++){
            if(minHeap.peek() > arr[i]) continue;
            else{
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }
        Iterator iterator = minHeap.iterator(); 
        while (iterator.hasNext()) 
        { 
            System.out.print(iterator.next() + " "); 
        } 
    }
}
