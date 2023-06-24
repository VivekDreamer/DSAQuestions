package org.vivek.dp.mixedQuestion;

import java.util.Arrays;
//https://practice.geeksforgeeks.org/problems/pairs-with-specific-difference1533/1
public class PairsWithCertainDifference {
    public static void main(String[] args) {
        int arr[] = {3, 5, 10, 15, 17, 12, 9}; int k = 4;
        int maxSumPairWithDifferenceLessThanK = maxSumPairWithDifferenceLessThanK(arr, arr.length, k);
        System.out.println(maxSumPairWithDifferenceLessThanK);
    }
    public static int maxSumPairWithDifferenceLessThanK(int arr[], int N, int K) {
        Arrays.sort(arr);
        int i = N-2;
        int sum = 0;
        while(i >= 0){
            int x = arr[i+1]-arr[i];
            if(x < K){
                sum+=arr[i+1];
                sum+=arr[i];
                i-=2;
            }
            else i--;
        }
        return sum;
    }
}
