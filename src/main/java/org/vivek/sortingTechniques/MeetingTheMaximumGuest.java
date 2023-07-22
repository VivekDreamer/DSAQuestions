package org.vivek.sortingTechniques;

import java.util.Arrays;

public class MeetingTheMaximumGuest {
    public static void main(String[] args) {
        int arr[] = { 900, 600, 700}; // 600, 700, 900
        int dep[] = { 1000, 800, 730}; // 730, 800, 1000
        int n = arr.length; 
        System.out.print(maxGuest(arr,dep, n));
    }
    // You are given arrival and departure times of the guests, you need to find the minimum time interval to attend the party 
    // so that there are maximum people at the party.
    private static int maxGuest(int[] arr, int[] dep, int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int res = 1;
        int curr = 1;
        int arrivalIdx = 1;
        int departureIdx = 0;
        while(arrivalIdx < n && departureIdx < n){
            if(arr[arrivalIdx] < dep[departureIdx]){
                curr++;
                arrivalIdx++;
            }else{
                curr--;
                departureIdx++;
            }
            res = Math.max(res,curr);
        }
        return res;
    }

}
