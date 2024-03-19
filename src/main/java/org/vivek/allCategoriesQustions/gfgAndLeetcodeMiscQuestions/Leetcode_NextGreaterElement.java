package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// https://leetcode.com/problems/next-greater-element-i/
public class Leetcode_NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        /*int[] gte = new int[nums2.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = nums2.length-1; i >= 0; i--){
            while(!stack.isEmpty() && stack.peek() <= nums2[i]) stack.pop();
            if(!stack.isEmpty()) gte[i] = stack.peek();
            else gte[i] = -1;
            stack.push(nums2[i]);
        }
        int length1 = nums1.length;
        int length2 = nums2.length;
        Set<Integer> set = new LinkedHashSet<>();
        for(int i = 0; i < length1; i++){
            for(int j = 0; j < length2; j++){
                if(nums1[i] == nums2[j]) set.add(j);
            }
        }
        int[] res = new int[set.size()];
        int i = 0;
        System.out.println(set);
        for(int idx : set){
            res[i++] = gte[idx];
        }
        return res;*/
        
        // Step 1: Construct a map to store the next greater element for each number in nums2
    Map<Integer, Integer> nextGreaterMap = new HashMap<>();
    Stack<Integer> stack = new Stack<>();
    for(int i = nums2.length-1; i >= 0; i--){
        while(!stack.isEmpty() && stack.peek() <= nums2[i]) stack.pop();
        if(!stack.isEmpty()) nextGreaterMap.put(nums2[i],stack.peek());
        stack.push(nums2[i]);
    }
    // for (int num : nums2) {
    //     while (!stack.isEmpty() && stack.peek() < num) {
    //         nextGreaterMap.put(stack.pop(), num);
    //     }
    //     stack.push(num);
    // }
    // System.out.println(nextGreaterMap);
    // Step 2: Build the result array using the map
    int[] result = new int[nums1.length];
    for (int i = 0; i < nums1.length; i++) {
        result[i] = nextGreaterMap.getOrDefault(nums1[i], -1);
    }
    
    return result;
    }
}
