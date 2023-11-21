package org.vivek.allCategoriesQustions.arrays;

public class MoveAllZeroesToEndOfArray {
    /*
    void pushZerosToEnd(int[] arr, int n) {
        int i = 0, j = 1;
        while(i < n-1 && j < n){
            if(arr[i] == 0 && arr[j] != 0){
                swap(arr,i,j);
                i++;
                j++;
            }
            else if(arr[i] != 0 && arr[j] == 0){
                i++;
                j++;
            }
            else if(arr[i] != 0 && arr[j] != 0){
                i++;
                j++;
            }
            else{
                j++;
            }
        }
    }
    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    */
    
    void pushZerosToEnd(int[] arr, int n){
        int count = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] != 0)
                arr[count++] = arr[i];
        }
        while(count < n){
            arr[count++] = 0;
        }
    }
}
