package org.vivek.allCategoriesQustions.binarySearch;

public class NumberOfTimesArrayRotated {
    private static int findKRotation(int[] arr, int n){
        int low = 0;
        int high = n - 1;
        int ans = Integer.MAX_VALUE;
        int idx = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[low] <= arr[high]){
                if(arr[low] < ans){
                    idx = low;
                    ans = arr[low];
                }
                break;
            }
            if(arr[low] <= arr[mid]){
                if(arr[low] < ans){
                    idx = low;
                    ans = arr[low];
                }
                low = mid + 1;
            } else {
                if(arr[mid] < ans){
                    idx = mid;
                    ans = arr[mid];
                }
                high = mid - 1;
            }
        }
        return idx;
    }
}
