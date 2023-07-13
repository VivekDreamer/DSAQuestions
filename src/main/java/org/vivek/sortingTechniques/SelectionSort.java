package org.vivek.sortingTechniques;

import java.util.Arrays;
//does less memory writes compared to ouicksort, mergesort, insertion sort etc.
//but cycle sort is optimal in memory writes
//this is the basic idea of heap sort
//not stable algorithm but it is in place algorithm
public class SelectionSort {
    public static void main(String[] args) {    
        int[] arr = {7,8,3,1,2};
        System.out.println("Before sorting : "+Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("After sorting : "+Arrays.toString(arr)); 
    }
    //in this, we are putting the smallest element in front...and swapping is done only one time
    public static void selectionSort(int[] arr){
        for(int i = 0; i < arr.length-1; i++){
            int smallestIdx = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[smallestIdx]>arr[j]) smallestIdx = j;
            }
            int temp = arr[i];
            arr[i] = arr[smallestIdx];
            arr[smallestIdx] = temp;
        }
    }
}
