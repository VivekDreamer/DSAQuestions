// https://www.geeksforgeeks.org/problems/aggressive-cows/1
public class POTD_AggressiveCows {
    public static int aggressiveCows(int[] stalls, int k) {
        int n = stalls.length;
        Arrays.sort(stalls);
        int low = 0;
        int high = stalls[n-1] - stalls[0];
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(canWePlaceCows(stalls,mid,n,k)){
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    public static boolean canWePlaceCows(int[] stalls, int dist, int n, int k){
        int numOfCows = 1;
        int lastLocationOfStall = stalls[0];
        for(int i = 1; i < n; i++){
            if(stalls[i] - lastLocationOfStall >= dist){
                numOfCows++;
                lastLocationOfStall = stalls[i];
            }
            if(numOfCows >= k) return true;
        }
        return false;
    }
}
