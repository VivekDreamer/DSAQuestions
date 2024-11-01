// https://www.geeksforgeeks.org/problems/swap-and-maximize5859/1
public class POTD_SwapAndMaximize {
    public long maxSum(Long[] arr) {
        Arrays.sort(arr);
        long ans = Math.abs(arr[0]-arr[arr.length/2]);
        int i = 0;
        int j = arr.length-1;
        while (i < j){
            ans = ans + Math.abs(arr[i]-arr[j]);
            i++;
            if (i != j) {
                ans = ans + Math.abs(arr[i]-arr[j]);
            }
            j--;
        }
        return ans;
    }
}
