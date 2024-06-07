// https://www.geeksforgeeks.org/problems/maximum-occured-integer4602/1
class POTD_MaximumOccuredInteger {
  public static int maxOccured(int n, int l[], int r[], int maxx) {
        int[] arr = new int[maxx+2];
        for(int i=0; i<n; i++) {
            int min = Math.min(l[i], r[i]);
            int max = Math.max(l[i], r[i]);
            arr[min]++;
            arr[max+1]--;
        }
        int occur = 1, ans = arr[0] > 0 ? 0 : Integer.MAX_VALUE;
        for(int i=1; i<arr.length; i++) {
            arr[i]+=arr[i-1];
            if(occur < arr[i]) { 
                occur = arr[i];
                ans = i;
            }
        }
        return ans;
    }
}
