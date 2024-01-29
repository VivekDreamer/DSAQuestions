package org.vivek.allCategoriesQustions.binarySearch;

import java.util.Arrays;

//problem link : https://bit.ly/43QDpdG
public class CapacityToShipPackagesWithinDDays {
    //brute force
    public static int leastWeightCapacity(int[] weights, int d) {
        int min = Arrays.stream(weights).max().orElseThrow();
        int max = Arrays.stream(weights).sum();
        for(int i = min; i <= max; i++){
            int numOfDaysReq = calculateDays(weights, i);
            if(numOfDaysReq <= d) return i;
        }
        return -1;
    }

    private static int calculateDays(int[] weights, int capacity) {
        int days = 1;
        int load = 0;
        int n = weights.length;
        for(int i = 0; i < n; i++){
            if(load + weights[i] > capacity){
                days++;
                load = weights[i];
            } else {
                load += weights[i];
            }
        }
        return days;
    }

    //optimized
    public static int leastWeightCapacity1(int[] weights, int d){
        int min = Arrays.stream(weights).max().orElseThrow();
        int max = Arrays.stream(weights).sum();
        while (min <= max) {
            int capacity = min + (max - min)/2;
            int requiredDays = calculateDays(weights, capacity);
            if(requiredDays <= d){
                max = capacity - 1;
            } else {
                min = capacity + 1;
            }
        }
        return min;
    }
}
