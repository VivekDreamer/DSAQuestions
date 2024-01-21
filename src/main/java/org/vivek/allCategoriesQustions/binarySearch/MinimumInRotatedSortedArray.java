package org.vivek.allCategoriesQustions.binarySearch;

public class MinimumInRotatedSortedArray {
    private static int findMinimum(int[] arr, int n){
        int low = 0; 
        int high = n - 1;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low)/2;
            //search space is already sorted
            //then, always arr[low] will be the smaller one in that search space
            if(arr[low] <= arr[high]){
                ans = Math.min(ans, arr[low]);
                break;
            }
            if(arr[mid] >= arr[low]){
                ans = Math.min(arr[low],ans);
                low = mid + 1;
            } else {
                ans = Math.min(ans, arr[mid]);
                high = mid - 1;
            }
        }
        return ans;
    }
}
