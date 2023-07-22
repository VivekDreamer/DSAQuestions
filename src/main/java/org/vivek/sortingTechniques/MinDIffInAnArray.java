package org.vivek.sortingTechniques;

import java.util.Arrays;

public class MinDIffInAnArray {
    public static void main(String[] args) {
        int[] arr = {1,8,12,5,18};
        int n = arr.length;
        int minDiff = getMinDiff(arr, n);
        System.out.println(minDiff);
        int getMinDiffEfficient = getMinDiffEfficient(arr, minDiff);
        System.out.println(getMinDiffEfficient);
    }
    public static int getMinDiff(int[] arr, int n){
        int res = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                res = Math.min(res,Math.abs(arr[i]-arr[j]));
            }
        }
        return res;
    }
    public static int getMinDiffEfficient(int[] arr, int n){
        int res = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for(int i = 1; i < n; i++){
            res = Math.min(res,Math.abs(arr[i]-arr[i-1]));
        }
        return res;
    }
}
