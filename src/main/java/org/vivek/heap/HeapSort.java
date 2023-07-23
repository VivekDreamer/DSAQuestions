package org.vivek.heap;

//HeapSort can be mainly seen as the improvement of selection sort, it uses heap datastructure and the concept of selection sort.
//Selection sort worst case time complexity is O(n^2) but heap sort time complexity is O(nlogn) which is the best time complexity we can get in
//any comparision based algoorithm. There are other sorting algorithm like merge sort and quick sort which also takes the O(nlogn) time.
//Merge sort take O(nlogn) time in the worst case and quick sort takes O(nlogn) time in average case. Heap sort takes O(nlogn) time in all cases.
//when we compare heap sort with merge and quick sort , the constants hidden in heap sort algorithm are higher than quick sort and merge sort.
//In practice merge sort and quick sort takes less time than heap sort. However, there are hybrid algorithm like introsort, which are based on quick sort
//As in quick sort, it may be possible that it may go beyond nlogn, it's recursion depth becomes O(logn). This introosort algorithm switches to heapsort when
//recuursion depth goes beyond logn
public class HeapSort {
    public static void main(String[] args) {
        //if we want to sort the array in increasing order then we have to build the maxHeap--> root is greater than it's descendents
        //if we want to sort the array in decreasing order then we have to build the minHeap
        int arr[] = {12, 11, 13, 5, 6, 7}; 
        HeapSort hs = new HeapSort();
        hs.printArray(arr);
        hs.sort(arr);
        hs.printArray(arr);
    }

    public void buildHeap(int[] arr, int n){
        for(int i = (n-2)/2; i >= 0; i--){
            heapify(arr,n,i);
        }
    }

    private void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2*i+1;
        int r = 2*i+2;
        if(l < n && arr[l] > arr[largest]) largest = l;
        if(r < n && arr[r] > arr[largest]) largest = r;
        if(largest != i){
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            heapify(arr, n, largest);
        }
    }

    public void sort(int[] arr){
        int n = arr.length;
        buildHeap(arr, n);
        for(int i = n-1; i > 0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    public void printArray(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n; ++i){
            System.out.print(arr[i]+" ");
        }
        System.out.println(); 
    }
}
