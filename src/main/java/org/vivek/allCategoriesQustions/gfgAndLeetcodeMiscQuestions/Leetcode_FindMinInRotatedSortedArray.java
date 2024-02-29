package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class Leetcode_FindMinInRotatedSortedArray {
    public int findMin(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        int mid = start + (end-start)/2;
        if(arr[start]<arr[end])
            return arr[start];
             
        while(start < end){
            if(arr[mid]>=arr[0])
                start = mid+1;
            else
                end = mid;
            mid = start + (end-start)/2;
        }
         return arr[start];
     }
}
