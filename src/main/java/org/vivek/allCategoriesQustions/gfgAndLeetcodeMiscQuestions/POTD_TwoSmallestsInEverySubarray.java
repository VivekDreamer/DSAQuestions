// https://www.geeksforgeeks.org/problems/maximum-sum-of-smallest-and-second-smallest-in-an-array/1
public class POTD_TwoSmallestsInEverySubarray {
    public int pairWithMaxSum(int[] arr) {
        if(arr.length==1){
            return -1;
        }
        int n = arr.length;
        int max =Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int sum = arr[i] + arr[i + 1];
            max = Math.max(sum, max); 
        } 
        return max;
    }
}
