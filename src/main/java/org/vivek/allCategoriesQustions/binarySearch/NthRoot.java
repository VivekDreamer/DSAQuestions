package org.vivek.allCategoriesQustions.binarySearch;

// You are given 2 numbers (n , m); the task is to find n√m (nth root of m)

// Algorithm:

// 1. Place the 2 pointers i.e. low and high: Initially, we will place the pointers. The pointer low will point to 1 and the high will point to m.
// 2. Calculate the ‘mid’: Now, inside a loop, we will calculate the value of ‘mid’ using the following formula:
// mid = (low+high) // 2 ( ‘//’ refers to integer division)
// 3. Eliminate the halves accordingly: 
//      1.If func(n, m, mid) == 1: On satisfying this condition, we can conclude that the number ‘mid’ is our answer. So, we will return to ‘mid’.
//      2.If func(n, m, mid) == 0: On satisfying this condition, we can conclude that the number ‘mid’ is smaller than our answer. So, we will eliminate the left half and consider the right half(i.e. low = mid+1).
//      3.If func(n, m, mid) == 2: the value mid is larger than the number we want. This means the numbers greater than ‘mid’ will not be our answers and the right half of ‘mid’ consists of such numbers. So, we will eliminate the right half and consider the left half(i.e. high = mid-1).
// Finally,  if we are outside the loop, this means no answer exists. So, we will return -1.
public class NthRoot {
    public int calculateNthRoot(int root, int number) {
        int low = 0;
        int high = number;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midComparison = compareMidValue(mid, root, number);
            if (midComparison == 1) {
                return mid;
            } else if (midComparison == 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private int compareMidValue(int mid, int root, int number) {
        long result = 1;
        for (int i = 1; i <= root; i++) {
            result *= mid;
            if (result > number) {
                return 2; // Mid value is too large
            }
        }
        if (result == number) {
            return 1; // Mid value is the nth root of m
        }
        return 0; // Mid value is too small
    }
}
