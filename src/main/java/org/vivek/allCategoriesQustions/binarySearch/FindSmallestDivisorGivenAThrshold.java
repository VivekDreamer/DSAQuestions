package org.vivek.allCategoriesQustions.binarySearch;

import java.util.Arrays;

// You are given an array of integers ‘arr’ and an integer i.e. a threshold value ‘limit’. Your task is to find the smallest positive integer divisor, such that upon dividing all the elements of the given array by it, 
// the sum of the division’s result is less than or equal to the given threshold value.
public class FindSmallestDivisorGivenAThrshold {

    //brute force approach
    public static int smallestDivisor(int[] arr, int threshold){
        int n = arr.length;
        if(n > threshold) return -1;
        int maxi = Arrays.stream(arr).max().orElseThrow();
    
        for(int d = 1; d <= maxi; d++){
            int sum = 0;
            for(int i = 0; i < n; i++){
                sum += Math.ceil((double)(arr[i]) / (double)(d));
            }
            if(sum <= threshold) return d;
        }
        return -1;
    }

    //optimal approach
    public static int smallestDivisor1(int[] arr, int threshold){
        int n = arr.length;
        int maxi = Arrays.stream(arr).max().orElseThrow();

        int low = 1;
        int high = maxi;
        while(low <= high){
            int divisor = low + (high - low)/2;
            if(sumByD(arr,divisor) <= threshold){
                high = divisor - 1;
            } else {
                low = divisor + 1;
            }
        }
        return low;
    }

    private static int sumByD(int[] arr, int divisor) {
        int n = arr.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += Math.ceil((double)(arr[i]) / (double)(divisor));
        }
        return sum;
    }

}
