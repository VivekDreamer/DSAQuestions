package org.vivek.allCategoriesQustions.arrays;

public class Leetcode_ElementAppearingMoreThanQuaterInASortedArray {
    /*
    public int findSpecialInteger(int[] arr) {
        double threshold = arr.length*0.25;
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int i : arr){
            freqMap.put(i,freqMap.getOrDefault(i,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : freqMap.entrySet()){
            if(entry.getValue() > threshold){
                return entry.getKey();
            }
        }
        return -1;
    }
    */

    public int findSpecialInteger(int[] arr) {
        int length = arr.length;
        int qtr = length/4;
        int cnt = 1;
        int p = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(p == arr[i]) cnt++;
            else cnt = 1;
            if(cnt > qtr) return arr[i];
            p = arr[i];
        }
        return p;
    }
}
