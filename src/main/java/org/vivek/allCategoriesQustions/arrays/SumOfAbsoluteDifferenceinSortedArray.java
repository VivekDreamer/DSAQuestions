package org.vivek.allCategoriesQustions.arrays;

import java.util.Arrays;

// https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/
public class SumOfAbsoluteDifferenceinSortedArray {
    //res[i] = (nums[i] - nums[0]) + (nums[i] - nums[1]) + (nums[i] - nums[2]) + (nums[i] - nums[i-1]) + ......+
    //         (nums[i+1] - nums[i]) + (nums[i+2] - nums[i]) + (nums[i+3] - nums[i]) + ...... + (nums[n-1] - nums[i])
    
    //res[i] = (nums[i] * i) - (Sum from 0 to (i-1) ) + (Sum from (i+1) to (n-1) ) - (nums[i] * (n-i-1))
    
    //with the use of extra array i.e, res
   
    
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for(int i = 1; i < n; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            int leftSum = prefixSum[i] - nums[i];
            int rightSum = prefixSum[n-1] - prefixSum[i];
            int leftCount = i;
            int rightCount = n-i-1;
            int leftTotal = (leftCount * nums[i]) - leftSum;
            int rightTotal = (rightSum) - (nums[i] * rightCount);
            res[i] = leftTotal + rightTotal;
        }
        return res;
    }

    //without the use of extra array 
    public int[] getSumAbsoluteDifferences1(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        int[] result = new int[n];
        int prefixSum = 0;
        for(int i = 0; i < n; i++){
            int leftSum = prefixSum;
            int rightSum = sum - prefixSum - nums[i];
            int leftCount = i;
            int rightCount = n - i - 1;
            int leftTotal = (leftCount * nums[i]) - leftSum;
            int rightTotal = rightSum - (nums[i] * rightCount);
            result[i] = leftTotal + rightTotal;
            prefixSum += nums[i];
        }
        return result;
    }
    
}
