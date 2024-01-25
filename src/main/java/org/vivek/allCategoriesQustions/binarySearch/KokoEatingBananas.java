package org.vivek.allCategoriesQustions.binarySearch;

import java.util.Arrays;

// Problem Statement: A monkey is given ‘n’ piles of bananas, whereas the ‘ith’ pile has ‘a[i]’ bananas. An integer ‘h’ is also given, which denotes the time (in hours) for all the bananas to be eaten.
// Each hour, the monkey chooses a non-empty pile of bananas and eats ‘k’ bananas. If the pile contains less than ‘k’ bananas, then the monkey consumes all the bananas and won’t eat any more bananas in that hour.
// Find the minimum number of bananas ‘k’ to eat per hour so that the monkey can eat all the bananas within ‘h’ hours.
public class KokoEatingBananas {

    //optimal approach by using binary search
    public int minEatingSpeed(int[] piles, int hours) {
        int low = 1;
        int high = Arrays.stream(piles).max().orElseThrow();
        while (low <= high) {
            int assumedSpeed = low + (high - low)/2;
            int totalHour = calculateTotalHours(piles,assumedSpeed);
            if(totalHour <= hours){
                high = assumedSpeed - 1;
            }else{
                low = assumedSpeed + 1;
            }
        }
        return low;
    }

    private int calculateTotalHours(int[] piles, int assumedSpeed) {
        int totalHour = 0;
        int n = piles.length;
        for(int i = 0; i < n; i++){
            totalHour += Math.ceil((double)(piles[i])/(double)(assumedSpeed));
        }
        return totalHour;
    }

    //brute force approach 
    public int minEatingSpeed1(int[] piles, int hours){
        int max = Arrays.stream(piles).max().orElseThrow();
        for(int i = 1; i <= max; i++){
            int reqTime = calculateTotalHours(piles, i);
                if(reqTime <= hours) return i;
        }
        return max;
    }
}
