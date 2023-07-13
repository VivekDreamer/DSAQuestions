package org.vivek.sortingTechniques;

import java.util.Arrays;
//In place and stable algorithm
//used in practice of small arrays(tim sort and Introsort)
//O(n) in best case and O(n^2) in worst case
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {7,8,3,1,2};
        System.out.println("Before sorting : "+Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("After sorting : "+Arrays.toString(arr)); 
    }
    //in this we make two part, the first part is sorted and other part is unsorted
    public static void insertionSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int current = arr[i];
            int j = i-1;
            while(j >= 0 && current < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = current;
        }
    }
}
