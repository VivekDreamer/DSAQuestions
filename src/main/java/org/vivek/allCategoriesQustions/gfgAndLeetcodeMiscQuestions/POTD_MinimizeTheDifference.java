// https://www.geeksforgeeks.org/problems/minimize-the-difference/1
class POTD_MinimizeTheDifference {
    public static int minimizeDifference(int n, int k, int[] arr) {
        int[] rightMax = new int[n];
        int[] rightMin = new int[n];
        rightMax[n-1] = arr[n-1];
        rightMin[n-1] = arr[n-1];
        for(int i = n-2; i >= 0; i--){
            rightMin[i] = Math.min(rightMin[i+1],arr[i]);
            rightMax[i] = Math.max(rightMax[i+1],arr[i]);
        }
        int i = 0, j = k-1, mn = Integer.MAX_VALUE, mx = Integer.MIN_VALUE, ans = Integer.MAX_VALUE;
        while(j < n){
            if(i != 0){
                mn = Math.min(arr[i-1],mn);
                mx = Math.max(arr[i-1],mx);
            }
            int temp1 = mx, temp2 = mn;
            if(j != n-1){
                temp1 = Math.max(mx, rightMax[j+1]);
                temp2 = Math.min(mn, rightMin[j+1]);
            }
            ans = Math.min(ans, Math.abs(temp1-temp2));
            i++;
            j++;
        }
        return ans;
    }
}
        
        
