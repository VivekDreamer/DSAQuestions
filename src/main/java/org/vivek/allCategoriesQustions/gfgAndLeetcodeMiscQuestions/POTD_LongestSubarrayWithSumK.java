class POTD_LongestSubarrayWithSumK {
    public int longestSubarray(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            sum+=arr[i];
            if(sum == k) max = Math.max(max,i+1);
            else if(map.containsKey(sum-k)) max = Math.max((i - map.get(sum-k)), max);
            if(!map.containsKey(sum)) map.put(sum,i);
        }
        return max;
    }
}
