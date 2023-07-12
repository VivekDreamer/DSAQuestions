package org.vivek.sortingTechniques;

import java.util.Arrays;

public class BubbleSort {
    
    public static void main(String[] args) {
        int[] arr = {7,8,3,1,2};
        System.out.println("Before sorting : "+Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("After sorting : "+Arrays.toString(arr)); 
    }
    public static void bubbleSort(int[] arr){
        for(int i = 0; i < arr.length-1; i++){
            for(int j = 0; j < arr.length-i-1; j++){
                //swap 
                //tske the heaviest bubble at the end of array by comparing and then, sorting
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
