package org.vivek.allCategoriesQustions.amazonQuestions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;

// https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1
public class MaximumOfAllSubArraysOfSizeK {
    public ArrayList<Integer> max_of_subarrays(int[] arr, int n, int k){
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < k-1; i++){
            pq.add(arr[i]);
        }
        for(int i = 0; i <= n-k; i++){
            pq.add(arr[i+k-1]);
            int max = pq.peek();
            ans.add(max);
            pq.remove(arr[i]);
        }

        return ans;
    }

    //sliding window
    public ArrayList<Integer> max_of_subarrays_1(int[] arr, int n, int k){
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        int i = 0, j = 0;
        while(j < n){
            //calculations for j
            while(!queue.isEmpty() && queue.peekLast() < arr[j]){
                queue.pollLast();
            }
            queue.offerLast(arr[j]);
            if(j - i + 1 < k) j++;
            else{
                ans.add(queue.peekFirst());
                //removing calculations for i
                if(queue.peekFirst() == arr[i]){
                    queue.pollFirst();
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}
