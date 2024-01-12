package org.vivek.allCategoriesQustions.binarySearch;

// The upper bound algorithm finds the first or the smallest index in a sorted array where the value at that index is greater than the given key 
// arr[ind] > target
public class UpperBoundInArray {
    public static int upperBound(int[] arr, int n, int target){
        int low = 0;
        int high = n-1;
        int ans = n;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if(arr[mid] > target){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
