// https://www.geeksforgeeks.org/problems/maximum-product-subarray3604/1
public class POTD_MaximumProductSubarray {
    // Function to find maximum product subarray
    int maxProduct(int[] arr) {
        int n = arr.length;
        int ans = arr[0];
        int min = arr[0];
        int max = arr[0];
        for(int i = 1; i < n; i++){
            if(arr[i] < 0){
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(arr[i],max*arr[i]);
            min = Math.min(arr[i],min*arr[i]);
            ans = Math.max(ans,max);
        }
        return ans;
    }
}
