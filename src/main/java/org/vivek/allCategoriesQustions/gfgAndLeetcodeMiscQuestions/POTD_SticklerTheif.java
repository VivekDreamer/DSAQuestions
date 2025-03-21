class POTD_SticklerTheif {
    public int findMaxSum(int arr[]) {
        int n = arr.length;
        int memo[] = new int[n+1];
        Arrays.fill(memo,-1);
        return findMaxSumUtil(arr,0,n,memo);
    }
    public int findMaxSumUtil(int arr[],int start, int n, int[] memo){
        if(start >= n) return 0;
        if(memo[start] != -1) return memo[start];
        int t1 = findMaxSumUtil(arr,start+2,n,memo); //taken at start
        int t2 = findMaxSumUtil(arr,start+1,n,memo); //not taken at start
        return memo[start] = Math.max(t1+arr[start],t2); 
    }
}
