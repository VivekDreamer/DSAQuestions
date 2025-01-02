// https://www.geeksforgeeks.org/problems/subarrays-with-sum-k/1
public class POTD_SubarraysWithSumK {
    /*
    public int countSubarrays(int arr[], int k) {
        int res = 0;
        int ans = 0;
        for(int i = 0; i < arr.length; i++){
            res = 0;
            for(int j = i; j < arr.length; j++){
                res += arr[j];
                if(res == k){
                    ans++;
                }
            }
        }
        return ans;
    }
    */
    public int countSubarrays(int[] arr, int k) {
        int prefixSum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            count += map.getOrDefault(prefixSum - k, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
