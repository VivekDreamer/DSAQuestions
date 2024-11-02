// https://www.geeksforgeeks.org/problems/kth-distance3757/1
public class POTD_KthDistance {
    public boolean checkDuplicatesWithinK(int[] arr, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i<arr.length; i++){
            if(mp.containsKey(arr[i])){
                int diff = i - mp.get(arr[i]);
                if(diff<=k) return true;
            }
            mp.put(arr[i], i);
        }
        return false;
    }
}
