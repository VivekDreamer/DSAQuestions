package org.vivek.allCategoriesQustions.binarySearch;

// The floor of square root of 28 is: 5
public class FindSqrt {
    private static int findSqrt(int n){
        int low = 0, high = n;
        while(low <= high){
            long mid = low + (high-low)/2;
            long val = mid * mid;
            if(val <= (long)(n)){
                low = (int)(mid + 1);
            } else {
                high = (int)(mid - 1);
            }
        }
        return high;
    }
}
