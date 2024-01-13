package org.vivek.allCategoriesQustions.binarySearch;

// You’re given an sorted array arr of n integers and an integer x. Find the floor and ceiling of x in arr[0..n-1].
// The floor of x is the largest element in the array which is smaller than or equal to x.
// The ceiling of x is the smallest element in the array greater than or equal to x.
public class FloorAndCeilInSortedArray {
    public static int findFloor(int[] arr, int n, int target){
        int low = 0;
        int high = n-1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if(arr[mid] <= target){
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int findCeil(int[] arr, int n, int target){
        int low = 0;
        int high = n-1;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] >= target){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
