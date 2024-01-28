package org.vivek.allCategoriesQustions.binarySearch;

// https://takeuforward.org/data-structure/median-of-two-sorted-arrays-of-different-sizes/
public class MedianOfTwoSortedArraysOfDifferentSizes {
    public static double findMedian(int[] a, int[] b){
        int n1 = a.length;
        int n2 = b.length;
        int[] res = new int[n1+n2];
        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2) {
            if(a[i] < b[j]){
                res[k++] = a[i++];
            } else {
                res[k++] = b[j++];
            }
        }
        //copy the left out element
        while(i < n1){
            res[k++] = a[i++];
        }
        while(j < n2){
            res[k++] = b[j++];
        }
        //find the median
        int n = n1 + n2;
        if(n % 2 == 1) {
            return (double)res[n/2];
        }
        double median = ((double)res[n/2] + (double)res[(n/2) - 1]) / 2.0;
        return median;
    }

    public static double findMedianBetter(int[] a, int[] b){
        int n1 = a.length;
        int n2 = b.length;
        int n = n1 + n2;
        //required indexes
        int ind2 = n/2;
        int ind1 = ind2 - 1;
        int count = 0;
        int ind1Element = -1;
        int ind2Element = -1;
        int i = 0, j = 0;
        while(i < n1 && j < n2){
            if(a[i] < b[j]){
                if(count == ind1) ind1Element = a[i];
                if(count == ind2) ind2Element = a[i];
                count++;
                i++;
            }
            else {
                if(count == ind1) ind1Element = b[j];
                if(count == ind2) ind2Element = b[j];
                count++;
                j++;
            }
        }

        //copy the left out array
        while(i < n1){
            if(count == ind1) ind1Element = a[i];
            if(count == ind2) ind2Element = a[i];
            count++;
            i++;
        }
        while (j < n2) {
            if(count == ind1) ind1Element = b[j];
            if(count == ind2) ind2Element = b[j];
            count++;
            j++;
        }

        //find the median
        if(n % 2 == 1){
            return (double) ind2Element;
        }
        return (double)((double)(ind1Element+ind2Element))/2.0;
    }

    //optimal
// We will check the formation of the left half for all possible values of x. Now, we know that the minimum possible value of x is 0 and the maximum is n1(i.e. The length of the considered array). 
// Now the range is sorted. So, we will apply the binary search on the possible values of x i.e. [0, n1].
// How to eliminate the halves based on the values of x: Binary search works by eliminating the halves in each step. 
// Upon closer observation, we can eliminate the halves based on the following conditions:
// If l1 > r2: This implies that we have considered more elements from arr1[] than necessary. 
// So, we have to take less elements from arr1[] and more from arr2[]. In such a scenario, we should try smaller values of x. To achieve this, we will eliminate the right half (high = mid-1).
// If l2 > r1: This implies that we have considered more elements from arr2[] than necessary. 
// So, we have to take less elements from arr2[] and more from arr1[]. In such a scenario, we should try bigger values of x. To achieve this, we will eliminate the left half (low = mid+1).
    public static double findMedianOptimal(int[] a, int[] b){
        int n1 = a.length;
        int n2 = b.length;
        if(n1 > n2) return findMedianOptimal(b, a);
        int n = n1 + n2;  //total length
        int left = (n1 + n2 + 1)/2; //length of left half
        //apply binary search
        int low = 0;
        int high = n1;
        while(low <= high){
            int mid1 = low + (high - low)/2;
            int mid2 = left - mid1;
            //calculate l1, l2, r1, r2
            int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? a[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n) ? a[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n) ? a[mid2] : Integer.MAX_VALUE;
            if(l1 <= r2 && l2 <= r1){
                if(n % 2 == 1){
                    return Math.max(l1, l2);
                } else {
                    return ((double)(Math.max(l1, l2) + Math.min(r1, r2)))/2.0;
                }
            } else if(l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
            
        }
        return 0; //dummy statement
    }
}
