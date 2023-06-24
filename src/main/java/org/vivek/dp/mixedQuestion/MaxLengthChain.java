package org.vivek.dp.mixedQuestion;

import java.util.Arrays;
//https://practice.geeksforgeeks.org/problems/max-length-chain/1
public class MaxLengthChain {
    public static void main(String[] args) {
       int N = 5;
       Pair[] p = new Pair[5];
       p[0] = new Pair(5, 24);
       p[1] = new Pair(39, 60);
       p[2] = new Pair(15, 28);
       p[3] = new Pair(27,40);
       p[4] = new Pair(50, 90);
       int maxChainLength = maxChainLength(p, N);
       System.out.println(maxChainLength);
       int maxChainLengthDP = maxChainLengthDP(p, N);
       System.out.println(maxChainLengthDP);
       int maxChainLengthOptimized = maxChainLengthOptimized(p, N);
       System.out.println(maxChainLengthOptimized);
    }

    //memoization 
    private static int maxChainLength(Pair arr[], int n){
        int[] memo = new int[n+1];
        Arrays.fill(memo,-1);
        Arrays.sort(arr,(a,b)->b.y-a.y);
        return maxChainLengthUtil(arr,n,0,memo);
    }
    private static int maxChainLengthUtil(Pair arr[],int n,int prev,int[] memo){
        if(n==0)return 0;
        int ans1=0;
        if(memo[n] != -1) return memo[n];
        if(prev<arr[n-1].x){
            ans1=maxChainLengthUtil(arr,n-1,arr[n-1].y,memo)+1;
        }
        return memo[n] = Math.max(ans1,maxChainLengthUtil(arr,n-1,prev,memo));
    }

    private static int maxChainLengthDP(Pair arr[], int n){
        int[] dp = new int[n+1];
        int i = 1;
        Arrays.sort(arr,(a,b)->a.y-b.y);
        int prev = 0;
        
        while(i <= n){
            int ans1 = 0;
            if(prev<arr[i-1].x){
                ans1=dp[i-1]+1;
                prev = arr[i-1].y;
            }
            dp[i] = Math.max(ans1,dp[i-1]);
            i++;
        }
        int maxi = Integer.MIN_VALUE;
        for(int num : dp)
            maxi = Math.max(num,maxi);
        return maxi;
    }

    private static int maxChainLengthOptimized(Pair arr[], int n)
    {
        // your code here
        Arrays.sort(arr,(p1,p2)->p1.y-p2.y);  //Sorting the array by second parameter(y)
        int ans=0;
        int prev=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i].x>prev){
                prev=arr[i].y;
                ans++;
            }
        }
        return ans;
    }
}
class Pair
{
    int x;
    int y;
    
    public Pair(int a, int b)
    {
        x = a;
        y = b;
    }
}
