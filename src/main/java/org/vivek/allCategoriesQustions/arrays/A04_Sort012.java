package org.vivek.allCategoriesQustions.arrays;

import java.util.Arrays;

public class A04_Sort012 {
    public static void main(String[] args) {
       int n = 5;
       int arr[]= {0, 2, 1, 2, 0};
       sort012(arr, n);
       System.out.println(Arrays.toString(arr));
    }

    /*public static void sort012(int a[], int n){
        int numOfZeroes = 0;
        int numOfOnes = 0;
        int numOfTwos = 0;
        for(int num : a){
            if(num == 0) numOfZeroes++;
            else if(num == 1) numOfOnes++;
            else if(num == 2) numOfTwos++;
        }
        int i = 0;
        while(i<n){
            if(numOfZeroes-- > 0) a[i++] = 0;
            else if(numOfOnes-- > 0) a[i++] = 1;
            else if(numOfTwos-- > 0) a[i++] = 2;
        }
    }*/
    
    public static void sort012(int arr[], int n){
        //dutch flag algorithm
        int low = 0;
        int mid = 0;
        int high = n-1;
        while(mid <= high){
            if(arr[mid] == 0){
                swap(arr, low, mid);
                low++;
                mid++;
            }
            else if(arr[mid] == 1){
                mid++;
            }
            else if(arr[mid] == 2){
                swap(arr, mid, high);
                high--;
            } 
        }
    }
    
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
