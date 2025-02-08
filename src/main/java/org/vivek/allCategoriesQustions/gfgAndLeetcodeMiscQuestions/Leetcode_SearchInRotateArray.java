class Leetcode_SearchInRotateArray {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int pivotIdx = findPivot(nums,0,n-1);
        //applying binary search on left side of pivot
        if(binarySearch(nums, 0, pivotIdx-1, target)) return true;
        //applying binary search on right side of pivot
        return binarySearch(nums, pivotIdx, n-1, target);
    }

    private boolean binarySearch(int[] nums, int l, int r, int target){
        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target) return true;
            if(nums[mid] < target) l = mid+1;
            else r = mid-1;
        }
        return false;
    }

    private int findPivot(int[] nums, int l, int r){
        while(l < r){
            while(l < r && nums[l] == nums[l+1]) l++;
            while(l < r && nums[r] == nums[r-1]) r--;
            /* we need to do above thing because
            Here, the nums[mid] <= nums[r] and
            and we will cut down the right half but our pivot lies there
            So, make it a RULE, whenever there are duplicate elements and you need to to something
            like Binary Search, you need to ignore duplicates like done above
            Similar Qn : "Smallest element in a rotated sorted array with duplicates" */
            int mid = l + (r-l)/2;
            if(nums[mid] <= nums[r]) r = mid;
            else l = mid+1; 
        }
        return r;
    }
}
