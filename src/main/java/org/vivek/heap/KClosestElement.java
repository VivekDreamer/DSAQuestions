package org.vivek.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

import javax.crypto.Mac;

public class KClosestElement {
    public static void main(String[] args) {
        int arr[] = { 10,30,5,40,38,80,70 };
	    int size = arr.length;
	    int x=35; int k = 3;
        printKClosest(arr,size,k,x);
    }
    //naive way
    private static void printKClosest(int[] arr, int size, int k, int x) {
        boolean[] visited = new boolean[size];
        for(int i = 0; i < k; i++){
            int minDiff = Integer.MAX_VALUE;
            int minDiffIdx = 0;
            for(int j = 0; j < size; j++){
                if(visited[j] == false && Math.abs(arr[j]-x)<=minDiff){
                    minDiff = Math.abs(arr[j]-x);
                    minDiffIdx = j;
                }
            }
            System.out.print(arr[minDiffIdx]+" ");
            visited[minDiffIdx] = true;
        }
    }

    public static void printKClosestEfficient(int[] arr, int size, int k, int x){
        //max heap
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for(int i = 0; i < k; i++){
            pq.offer(new Pair(arr[i],  Math.abs(arr[i]-x)));
        }
        for(int i = k; i < size; i++){
            int diff = Math.abs(arr[i]-x);
            if(pq.peek().getValue()>diff){
                pq.poll();
                pq.offer(new Pair(arr[i],diff));
            }
        }
        while(!pq.isEmpty()){
            System.out.print(pq.poll().getKey()+" ");
        }

    }

    static class Pair{
        Integer key;
        Integer value;
        public Pair(Integer key, Integer value){
            this.key = key;
            this.value = value;
        }
        public Integer getKey() {
            return key;
        }
        public void setKey(Integer key) {
            this.key = key;
        }
        public Integer getValue() {
            return value;
        }
        public void setValue(Integer value) {
            this.value = value;
        }
    }
}
