// https://www.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1
public class POTD_KadaneAlgo{
    // arr: input array
    // n: size of array
    //Function to find the sum of contiguous subarray with maximum sum.
    long maxSubarraySum(int arr[]){
        int n = arr.length;
        long sum = 0;
        long res = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            sum += arr[i];
            res = Math.max(res,sum);
            if(sum <= 0) sum = 0;
        }
        return res;
    }
    
}
