class POTD_StrictlyIncreasingArray
{
    public int min_operations(int []nums){
        //LIS
        if(nums.length == 1) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int max = 1;
        for(int i = 0; i < nums.length; i++){
            for(int prev = 0; prev < i; prev++){
                if((nums[prev] < nums[i]) && (nums[i]-nums[prev]>i-prev-1)){
                    dp[i] = Math.max(dp[i],1+dp[prev]);
                }
                max = Math.max(max, dp[i]);
            }
        }
        return nums.length-max;
    }
}
