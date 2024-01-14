package org.vivek.allCategoriesQustions.binarySearch;

public class FirstAndLastOccuranceInAnArray {
    public static int lowerBound(int[] arr, int n, int target){
        int low = 0;
        int high = n-1;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] >= target){
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    public static int upperBound(int[] arr, int n, int target){
        int low = 0;
        int high = n-1;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] > target){
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    public static int[] firstAndLastOccuranceInArray(int[] arr, int n, int target){
        int lowerBound = lowerBound(arr, n, target);
        if(lowerBound == n || arr[lowerBound] != target){
            return new int[]{-1,-1};
        }
        return new int[]{lowerBound,upperBound(arr, n, target)-1};
    }

    public static int[] firstAndLastOccuranceInArray2(int[] arr, int n, int target){
        int firstOccurance = firstOccurance(arr, n, target);
        if(firstOccurance == -1) return new int[]{-1,-1}; 
        int lastOccurance = lastOccurance(arr, n, target);
        return new int[]{firstOccurance,lastOccurance};
    }
    public static int firstOccurance(int[] arr, int n, int target){
        int low = 0;
        int high = n-1;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target){
                ans = mid;
                high = mid - 1;
            } else if(arr[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    public static int lastOccurance(int[] arr, int n, int target){
        int low = 0;
        int high = n-1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if(arr[mid] == target){
                ans = mid;
                low = mid + 1;
            } else if(arr[mid] < target){
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }
        return ans;
    }
}
