package org.vivek.sortingTechniques.partitionAlgorithm;

//Time complexity : O(n)
//space complexity : O(n)
public class NaivePartition {
    public static void main(String[] args) {
        int arr[] = new int[]{5,13,6,9,12,11,8};
        int n = arr.length;
        partition(arr,0,n-1,n-1);
	    for(int x: arr)
	        System.out.print(x+" ");
    }
    //do partition around pivot element
    //all the smaller or equal elements came befor pivot element
    //and all the elements greater than the pivot element comes after pivot element
    public static void partition(int[] arr, int l, int h, int p){
        int[] temp = new int[h-l+1];
        int idx = 0;
        for(int i = l; i < h; i++){
            if(arr[i] <= arr[p] && i != p){
                temp[idx]=arr[i];
                idx++;
            }
        }
        temp[idx++] = arr[p];
        for(int i=l;i<=h;i++)
            if(arr[i]>arr[p])
                {
                    temp[idx]=arr[i];
                    idx++;
                }
        for(int i=l;i<=h;i++)
            arr[i]=temp[i-l];
    }
}
