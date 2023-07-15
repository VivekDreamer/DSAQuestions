package org.vivek.sortingTechniques;
//https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
public class CountInversionsInAnArray {
    public static void main (String[] args) 
    {
        int arr[] = new int[]{2,4,1,3,5};
        int n = arr.length;
	    System.out.println(countInversions(arr,n));
        System.out.println(countInversionsEff(arr,0,n-1));
    }
    // naive
    public static int countInversions(int[] arr, int n){
        int result = 0;
        for(int i = 0; i < (n-1); i++){
            for(int j = i+1; j < n; j++){
                if(arr[i] > arr[j]) result++;
            }
        }
        return result;
    }
    public static int countInversionsEff(int[] arr,int l, int r){
        int res = 0;
        if(l < r){
            int m = (r+l)/2;
            res += countInversionsEff(arr, l, m);
            res += countInversionsEff(arr, m+1, r);
            res += countAndMerge(arr,l,m,r);
        }
        return res;
    }
    public static int countAndMerge(int[] arr, int l, int m, int r){
        int n1 = m-l+1;
        int n2 = r-m;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for(int i = 0; i < n1; i++){
            left[i] = arr[i+l];
        }
        for(int j = 0; j < n2; j++){
            right[j] = arr[m+j+1];
        }
        int res = 0, i = 0, j = 0, k = l;
        while(i < n1 && j < n2){
            if(left[i]<=right[j]) arr[k++] = left[i++];
            else{
                arr[k++] = right[j++];
                res = res + (n1 - i);
            }
        }
        while(i<n1)
            arr[k++]=left[i++];
        while(j<n2)
            arr[k++]=right[j++];
        return res;
    }
}
