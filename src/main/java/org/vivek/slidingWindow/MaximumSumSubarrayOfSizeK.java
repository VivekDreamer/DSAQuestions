package org.vivek.slidingWindow;

public class MaximumSumSubarrayOfSizeK {
    public static void main(String[] args) {
        int n = 4, k = 2;
        int[] arr = {100, 200, 300, 400};
        int maxSumSubArray = maxSumSubArray(arr, n, k);
        System.out.println(maxSumSubArray);
    }
    public static int maxSumSubArray(int[] arr, int n, int k){
        int i = 0; int j = 0;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        while(j < n){
            sum += arr[j];
            if(j-i+1 < k){
                j++; 
            }
            else if(j-i+1 == k){
                maxSum = Math.max(maxSum, sum);
                sum -= arr[i];
                i++;
                j++;
            }
        }
        return maxSum;
    }
}
