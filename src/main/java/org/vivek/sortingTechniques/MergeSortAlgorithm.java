package org.vivek.sortingTechniques;

public class MergeSortAlgorithm {
    public static void main(String[] args) {
        int[] arr = {10,5,30,15,7};
        int l = 0, r = 4;
        mergeSort(arr,l,r);
        for(int x: arr)
	        System.out.print(x+" ");
    }

    private static void mergeSort(int[] arr, int l, int r){
        if(r > l){
            int m = l+(r-l)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            merge(arr,l,m,r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r){
        int n1 = m-l+1;
        int n2 = r-m;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for(int i = 0; i < n1; i++)left[i] = arr[i+l];
        for(int j = 0; j < n2; j++)right[j] = arr[m+j+1];
        int i = 0, j = 0, k = l;
        while(i < n1 && j < n2){
            if(left[i] <= right[j]) arr[k++] = left[i++];
            else arr[k++] = right[j++];
        }
        while(i<n1)
            arr[k++]=left[i++];
        while(j<n2)
            arr[k++]=right[j++]; 
    }
}
