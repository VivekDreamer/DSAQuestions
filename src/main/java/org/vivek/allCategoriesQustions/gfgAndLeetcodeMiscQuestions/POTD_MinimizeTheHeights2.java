// https://www.geeksforgeeks.org/problems/minimize-the-heights3351/1
public class POTD_MinimizeTheHeights2 {
    int getMinDiff(int[] arr, int k) {
        int n = arr.length;
        if(n == 1) return 0;
        Arrays.sort(arr);
        int max = 0, min = 0;
        int diff = arr[n-1]-arr[0];
        
        for(int i = 1; i < n; i++){
            if(arr[i]-k < 0) continue;
            max = Math.max(arr[i-1]+k , arr[n-1]-k);
            min = Math.min(arr[0]+k , arr[i]-k);
            diff = Math.min(diff,max-min);
        }
        
        return diff;
    }
}
