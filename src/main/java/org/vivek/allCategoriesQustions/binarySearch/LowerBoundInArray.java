package org.vivek.allCategoriesQustions.binarySearch;

// The lower bound algorithm finds the first or the smallest index in a sorted array where the value at that index is greater than or equal to a given key 
// arr[ind] >= targetKey
public class LowerBoundInArray {
    public static int lowerBound(int[] arr, int n, int target){
        int low = 0;
        int high = n-1;
        int ans = n;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] >= target){
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
}
