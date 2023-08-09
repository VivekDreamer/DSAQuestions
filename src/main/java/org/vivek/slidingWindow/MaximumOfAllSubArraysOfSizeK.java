package org.vivek.slidingWindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// https://leetcode.com/problems/sliding-window-maximum/description/
public class MaximumOfAllSubArraysOfSizeK {
    public static void main(String[] args) {
    //    int[] nums = {1,3,-1,-3,5,3,6,7}; int k = 3;
    //    int[] nums = {1,-1}; int k = 1;
    //    int[] nums = {1}; int k = 1;
    int[] nums = {1,3,1,2,0,5}; int k = 3;
       //output = {3,3,2,5}
       //output = {3,3,5,5,6,7}
       int[] maxSlidingWindow = maxSlidingWindow(nums,k);
       System.out.println(Arrays.toString(maxSlidingWindow));
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int i = 0; int j = 0;
        int[] res = new int[nums.length-k+1];
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int idx = 0;
        while(j < n){
            while(!deque.isEmpty() && deque.peekLast() < nums[j]){
                deque.pollLast();
            }
            deque.offerLast(nums[j]);
            if(j - i + 1 < k) j++;
            else if(j - i + 1 == k){
                res[idx++] = deque.peekFirst();
                if(deque.peekFirst() == nums[i]) deque.removeFirst();
                i++;
                j++;
            }
        }
        return res;
    }
}
