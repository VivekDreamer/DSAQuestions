// https://www.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1
public class POTD_TrappingRainWater {
    public int maxWater(int arr[]) {
        int n = arr.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = arr[0];
        rightMax[n-1] = arr[n-1];
        for(int i = 1; i < n; i++){
            leftMax[i] = Math.max(leftMax[i-1],arr[i]);
        }
        for(int i = n-2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i+1],arr[i]);
        }
        //leftMax  = 3,3,3,3,3,4
        //rightMax = 4,4,4,4,4,4
        int res = 0;
        for(int i = 1; i < n; i++){
            res = res + Math.min(leftMax[i],rightMax[i])-arr[i];
        }
        return res;
    }
}
