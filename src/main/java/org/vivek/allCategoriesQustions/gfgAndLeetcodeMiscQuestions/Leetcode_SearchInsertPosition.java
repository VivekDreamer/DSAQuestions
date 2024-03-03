package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

// https://leetcode.com/problems/search-insert-position/
public class Leetcode_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        // binary search
		int low = 0;
		int high = nums.length - 1;
		int mid = 0;
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] < target)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return low;
	}
}
