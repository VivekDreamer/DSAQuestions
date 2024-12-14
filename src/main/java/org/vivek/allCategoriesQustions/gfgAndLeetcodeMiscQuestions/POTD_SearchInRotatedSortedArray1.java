// https://www.geeksforgeeks.org/problems/search-in-a-rotated-array4618/1
public class POTD_SearchInRotatedSortedArray1 {
    int search(int[] arr, int key) {
        int pivotIdx = getPivot(arr,arr.length);
        int result = -1;
        if(key >= arr[pivotIdx] && key <= arr[arr.length-1]) result = binarySearch(arr,pivotIdx,arr.length-1,key);
        else result = binarySearch(arr,0,pivotIdx-1,key);
        return result;
    }
    int getPivot(int[] arr, int n){
        if(arr[0] < arr[n-1] || n == 1) return 0;
        int start = 0;
        int end = n-1;
        int mid = start + (end - start)/2;
        while(start < end){
            if(arr[mid] >= arr[0]) start = mid+1;
            else end = mid;
            mid = start + (end-start)/2;
        }
        return start;
    }
    int binarySearch(int[] arr, int start, int end, int key){
        int mid = start+(end-start)/2;
        while(start<=end){
            if(arr[mid] == key) return mid;
            if(arr[mid] < key) start = mid + 1;
            else end = mid - 1;
            mid = start + (end - start)/2;
        }
        return -1;
    }
}
