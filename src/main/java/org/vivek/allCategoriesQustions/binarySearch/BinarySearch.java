package org.vivek.allCategoriesQustions.binarySearch;

public class BinarySearch {
    
    //iterative approach
    public static int binarySearch(int[] nums, int target){
        int low = 0; int high = nums.length-1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }

    //recursive approach
    public static int binarySearchHelper(int[] nums, int low, int high, int target){
        if(low > high) return -1;
        int mid = low + (high-low)/2;
        if(nums[mid] == target) return mid;
        else if(nums[mid] < target) return binarySearchHelper(nums, mid+1, high, target);
        else return binarySearchHelper(nums, low, mid-1, target);
    }
}
