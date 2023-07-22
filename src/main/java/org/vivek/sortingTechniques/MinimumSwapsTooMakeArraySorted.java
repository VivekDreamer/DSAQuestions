package org.vivek.sortingTechniques;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumSwapsTooMakeArraySorted {
    public static void main(String[] args) {
        int[] nums = {10, 19, 6, 3, 5};
        int minSwaps = minSwaps(nums);
        System.out.println(minSwaps);
    }
    public static int minSwaps(int[] nums){
        int n = nums.length;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = nums[i];
        }
        Arrays.sort(arr);
        //Map of array element at a particular index
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++)
            map.put(arr[i],i);
        int count = 0;
        for(int i = 0; i < n; i++){
            while(map.get(nums[i]) != i){
                count++;
                swap(nums,map.get(nums[i]),i);
            }
        }
        return count;
    }
    private static void swap(int[] nums, int j, int i) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
