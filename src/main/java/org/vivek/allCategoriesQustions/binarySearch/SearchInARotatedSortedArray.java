package org.vivek.allCategoriesQustions.binarySearch;


public class SearchInARotatedSortedArray {
    //for all unique elements in an array
    public static int search(int[] arr, int n, int target){
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if(arr[mid] == target) return arr[mid];
            //means left half is sorted
            if(arr[low] <= arr[mid]){
                if(arr[low] <= target && target <= arr[mid]){
                    high = mid - 1; 
                } else {
                    low = mid + 1;
                }
            }
            //right half is sorted
            else{
                if(arr[mid] <= target && target <= arr[high]){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
    //duplicates may be there in array
    public static boolean search2(int[] arr, int n, int target){
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if(arr[mid] == target) return true;
            if(arr[low] == arr[mid] && arr[high] == arr[mid]){
                low++; high--;
                continue;
            }
            if(arr[low] <= arr[mid]){
                if(arr[low] <= target && target <= arr[mid]){
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            else{
                if(target >= arr[mid] && target <= arr[high]){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
