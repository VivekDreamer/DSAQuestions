package org.vivek.heap;

import java.util.PriorityQueue;

public class BuyMaximumItemsWithGivenSum {
    public static void main(String[] args) {
        int cost[]=new int[]{1,12,5,111,200};
        int sum=10;
        int maxItems = maxItems(cost, sum);
        System.out.println(maxItems);
    }
    public static int maxItems(int[] arr, int sum){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < arr.length; i++) pq.add(arr[i]);
        int res = 0;
        for(int i = 0; i < arr.length; i++){
            if(pq.peek()<=sum){
                sum-=pq.poll();
                res++;
            }else break;
        }
        return res;
    }
}
