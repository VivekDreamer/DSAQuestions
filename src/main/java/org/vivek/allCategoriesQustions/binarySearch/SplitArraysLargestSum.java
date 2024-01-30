package org.vivek.allCategoriesQustions.binarySearch;

import java.util.Arrays;

// Given an integer array ‘A’ of size ‘N’ and an integer ‘K’. Split the array ‘A’ into ‘K’ non-empty subarrays such that the largest sum of any subarray is minimized. Your task is to return the minimized largest sum of the split.
// A subarray is a contiguous part of the array.
public class SplitArraysLargestSum {

// Minimum possible answer: We will get the minimum answer when we split the array into n subarrays(i.e. Each subarray will have a single element). Now, in this case, the maximum subarray sum will be the maximum element in the array. So, the minimum possible answer is max(arr[]).
// Maximum possible answer: We will get the maximum answer when we put all n elements into a single subarray. The maximum subarray sum will be the summation of array elements i.e. sum(arr[]). So, the maximum possible answer is sum(arr[]).

// From the observations, it is clear that our answer lies in the range [max(arr[]), sum(arr[])].
    public static int largestSubarraySumMinimized(int[] arr, int k) {
        int low = Arrays.stream(arr).max().orElseThrow();
        int high = Arrays.stream(arr).sum();
        for(int maxSum = low; maxSum <= high; maxSum++){
            if(countPartition(arr,k,maxSum) == k) return maxSum;
        }
        return low;
    }

    private static int countPartition(int[] arr, int k, int maxSum) {
        int partition = 1;
        int subarraySum = 0;
        for(int i = 0; i < arr.length; i++){
            if(subarraySum + arr[i] <= maxSum){
                subarraySum += arr[i];
            } else{
                subarraySum = arr[i];
                partition++;
            }
        }
        return partition;
    }

    public static int largestSubarraySumMinimizedOtimized(int[] arr, int k){
        int low = Arrays.stream(arr).max().orElseThrow();
        int high = Arrays.stream(arr).sum();
        while(low <= high){
            int maxSum = low + (high - low)/2;
            if(countPartition(arr, k, maxSum) > k){
                low = maxSum + 1;
            } else {
                high = maxSum - 1;
            }
        }
        return low;
    }
}
