package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

import java.util.HashMap;
import java.util.Map;

// https://www.geeksforgeeks.org/problems/first-element-to-occur-k-times5150/1
public class POTD_FirstElementToOccurKTimes {
    public int firstElementKTime(int n, int k, int[] arr) { 
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int count = map.containsKey(arr[i]) ? map.get(arr[i]) : 0;
            map.put(arr[i],++count);
            if(count == k) return arr[i];
        }
        return -1;
    }
}
