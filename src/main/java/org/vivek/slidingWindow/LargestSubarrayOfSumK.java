package org.vivek.slidingWindow;

import java.util.HashMap;

public class LargestSubarrayOfSumK {
    public static void main(String[] args) {
        // int[] arr = {4, 1, 1, 1, 2, 3, 5};
        // int[] arr = {2, 1, 1, 3, 1};
        int[] arr = {-5, 8, -14, 2, 4, 12};
        int targetSum = -5;
        // int targetSum = 5;
        // int longestSubarraySum = longestSubarraySum(arr, targetSum);
        int lenOfLongSubarr = lenOfLongSubarr(arr, arr.length, targetSum);
        System.out.println(lenOfLongSubarr);
    }
    //this 
    private static int longestSubarraySum(int[] arr, int targetSum){
        int start = 0, end = 0;
        int max_value = Integer.MIN_VALUE;
        int temp_sum = 0;
        while(end < arr.length){
            temp_sum += arr[end];
            if(temp_sum < targetSum) end++;
            else if (temp_sum == targetSum){
                max_value = Math.max(max_value, end-start+1);
                end++;
            }else if(temp_sum > targetSum){
                while(temp_sum > targetSum && start != arr.length){
                    temp_sum -= arr[start];
                    start++;
                }
                if(temp_sum == targetSum) max_value = Math.max(max_value, end-start+1);
                end++;
            }
        }
        return max_value;
    }

     public static int lenOfLongSubarr (int arr[], int n, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        int sum = 0;
        
        for(int i=0;i<n;i++){
            sum += arr[i];
            if(sum == k){
                max = Math.max(i+1 , max);
            }
            else if(map.containsKey(sum-k)){
                max = Math.max(i-map.get(sum-k) , max);
            }
            if(!(map.containsKey(sum))){
                map.put(sum, i);    
            }
        }
        return max;
    }
}
