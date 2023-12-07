package org.vivek.allCategoriesQustions.arrays;

// https://www.geeksforgeeks.org/problems/number-of-subarrays-with-maximum-values-in-given-range5949/1
public class POTD_NumberOfSubarraysWithMaximumValuesInGivenRange {
    static long countSubarrays(int a[], int n, int l, int r) {
        long start = 0, ans = 0, empire = 0;
        for (int end = 0; end < n; end++) {
            if (a[end] >= l && a[end] <= r) {
                // king
                empire = end - start + 1;
            } else if (a[end] > r) {
                // villain
                empire = 0; // king ka empire tut gaya
                start = end + 1; // naya empire
            }
            ans += empire;
        }
        return ans;
    }
}
