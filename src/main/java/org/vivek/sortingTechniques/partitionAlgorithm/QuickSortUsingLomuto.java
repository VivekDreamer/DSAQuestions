package org.vivek.sortingTechniques.partitionAlgorithm;

//Quick sort
//1. divide and conquer algorithm
//2. worst case time : O(n^2)
//3. Despite O(n^2) worst case, it is considered faster, because of the following
//i).   In place
//ii).  cache friendly
//iii). Average case is O(nlogn)
//iv).  Tail recursive
//v).   partition is key function(Naive, lomuto and hoarse )
//4. Many library implementation uses quick sort where stability is not required
//5. For eg. in c++, there are twoo functions sort and stablesort, sort function uses quick sort variation internally using an algorithm introsort which is 
//   hybrid of quicksort, heap sort and insertion sort
//6. java uses quick sort of sorting primitive data type. For non-primitive data type, java uses tim sort which is also used in python. And tim sort is a variation
//   of merge sort 
public class QuickSortUsingLomuto {
    public static void main (String[] args) 
    {
        int arr[] = new int[]{8,4,7,9,3,10,5};
        int n = arr.length;
        qSort(arr,0,n-1);
	    for(int x: arr)
	        System.out.print(x+" ");
    }
    
    static int iPartition(int arr[], int l, int h)
    {   
        int pivot=arr[h];
        int i=l-1;
        for(int j=l;j<=h-1;j++){
            if(arr[j]<pivot){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp=arr[i+1];
        arr[i+1]=arr[h];
        arr[h]=temp;
        return i+1;
    }
    
    static void qSort(int arr[],int l,int h){
        if(l<h){
            int p=iPartition(arr,l,h);
            qSort(arr,l,p-1);
            qSort(arr,p+1,h);
        }
    }
}