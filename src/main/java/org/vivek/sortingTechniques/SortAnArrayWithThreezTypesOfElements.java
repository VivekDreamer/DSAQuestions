package org.vivek.sortingTechniques;
// a famous interview problem in which you need to segregate an array of elements containing three types of elements. The types are:
// 1. Sort an array of 0s, 1s, 2s.
// 2. Three-way partitioning when multiple occurrences of a pivot may exist.
// 3. Partitioning around a range.
public class SortAnArrayWithThreezTypesOfElements {
    public static void main(String[] args) {
        int arr[] = new int[]{0,1,1,2,0,1,1,2};
        int n = arr.length;
        // sort(arr,n);
	    // for(int x:arr)
        //     System.out.print(x+" ");
        sortEfficient(arr, n);
        for(int x:arr)
            System.out.print(x+" ");
    }
    public static void sort(int[] arr, int n){
        int[] temp = new int[n];
        int i = 0;
        for(int j = 0; j < n; j++){
            if(arr[j] == 0) temp[i++] = arr[j];
        }
        for(int j = 0; j < n; j++){
            if(arr[j] == 1) temp[i++] = arr[j];
        }
        for(int j = 0; j < n; j++){
            if(arr[j] == 2) temp[i++] = arr[j];
        }
        for(int j = 0; j < n; j++){
            arr[j] = temp[j];
        }
    }
    //dutch national flag algorithm
    public static void sortEfficient(int[] arr, int n){
        int mid = 0;
        int low = 0;
        int high = n-1;
        while(mid <= high){
            if(arr[mid] == 0){
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            }
            else if(arr[mid] == 1){
                mid++;
            }
            else if(arr[mid] == 2){
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }
}
