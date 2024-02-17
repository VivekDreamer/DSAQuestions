package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

// https://leetcode.com/problems/majority-element/
public class Leetcode_MajorityElement {
    public int majorityElement(int[] nums) {
        //Boyer's moore voting algorithm
        int candidate = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == candidate) count++;
            else if(count == 0)
            {
                count = 1;
                candidate = nums[i];
            }
            else count--;
        }
        return candidate;
    }
}
