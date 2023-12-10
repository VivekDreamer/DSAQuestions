package org.vivek.allCategoriesQustions.arrays;

import java.util.HashMap;
import java.util.Map;
// https://www.geeksforgeeks.org/problems/subarray-with-0-sum-1587115621/1
public class POTD_SubarrayWithZeroSum {
    /*
    static boolean findsum(int arr[],int n){
        int flag = 0;
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = i; j < n; j++){
                sum = sum + arr[j];
                if(sum == 0){
                    flag = 1; 
                    break;
                }
            }
            if(flag == 1) break;
        }
        
        if(flag == 1) return true;
        return false;
    }
    */
    
    static boolean findsum(int arr[],int n){
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int flag = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
            if(sum == 0 || arr[i] == 0 || map.containsKey(sum)){
                flag = 1;
                break;
            }else{
                map.put(sum,1);
            }
        }
        if(flag == 1) return true;
        return false;
    }
}
