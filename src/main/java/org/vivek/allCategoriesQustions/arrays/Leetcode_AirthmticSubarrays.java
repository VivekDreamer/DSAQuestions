package org.vivek.allCategoriesQustions.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
// https://leetcode.com/problems/arithmetic-subarrays/
public class Leetcode_AirthmticSubarrays {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int m = l.length;
        List<Boolean> result = new ArrayList<>();
        for(int i = 0; i < m; i++){
            List<Integer> arr = new ArrayList<>();
            for(int j = l[i]; j <= r[i]; j++){
                arr.add(nums[j]);
            }
            result.add(check1(arr));
        }
        return result;
    }
    //with sorting
    public boolean check(List<Integer> arr){
        Collections.sort(arr);
        int n = arr.size();
        int d = arr.get(1) - arr.get(0);
        for(int i = 2; i < n; i++){
            if(arr.get(i) - arr.get(i-1) != d){
                return false;
            }
        }
        return true;
    }
    
    //without sorting 
    public boolean check1(List<Integer> arr) {
        int n = arr.size();
        int minElement = Integer.MAX_VALUE;
        int maxElement = Integer.MIN_VALUE;
        Set<Integer> st = new HashSet<>();
        for (int num : arr) {
            minElement = Math.min(minElement, num);
            maxElement = Math.max(maxElement, num);
            st.add(num);
        }
        if ((maxElement - minElement) % (n - 1) != 0) {
            return false;
        }
        int diff = (maxElement - minElement) / (n - 1);
        int curr = minElement + diff;
        while (curr < maxElement) {
            if (!st.contains(curr)) {
                return false;
            }
            curr += diff;
        }
        return true;
    }
}
