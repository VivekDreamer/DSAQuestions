package org.vivek.sortingTechniques.partitionAlgorithm;

//always consider last element as pivot...
//if pivot is not the last element then, just swap the pivot and last element and then, apply the lomuto partition
public class LomutoPartition {
    public static void main(String[] args) {
        int arr[] = new int[]{10,80,30,90,40,50,70};
        int n = arr.length;
        lomutoPartition(arr,0,n-1);
        
	    for(int x: arr)
	        System.out.print(x+" ");
    }
    public static int lomutoPartition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low - 1;
        for(int j = low; j <= high-1; j++){
            if(arr[j] < pivot){
                i++;
                //swap(arr[i],arr[j])
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //swap(arr[i+1],arr[h])
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return (i+1);
    }
}
