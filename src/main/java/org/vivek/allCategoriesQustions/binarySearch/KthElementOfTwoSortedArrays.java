package org.vivek.allCategoriesQustions.binarySearch;

// https://www.youtube.com/watch?v=D1oDwWCq50g&list=PLgUwDviBIf0pMFMWuuvDNMAkoQFi-h0ZF&index=24
public class KthElementOfTwoSortedArrays {
    public static int kthElement(int[] array1, int[] array2, int m, int n, int k){
        int p1 = 0, p2 = 0, counter = 0, answer = 0;
        while (p1 < m && p2 < n) {
            if(counter == k) break;
            if(array1[p1] < array2[p2]){
                answer = array1[p1];
                ++p1;
            }else{
                answer = array2[p2];
                ++p2;
            }
            ++counter;
        }
        if(counter != k){
            if(p1 != m-1){
                answer = array1[k-counter];
            }else{
                answer = array2[k-counter];
            }
        }
        return answer;
    }

    //optimal
    public static int kthElementOptimal(int[] array1, int[] array2, int n1, int n2, int k){
        if(n1 > n2) return kthElementOptimal(array2, array1, n2, n1, k);
        int low = Math.max(0, k-n2);
        int high = Math.min(k,n1);
        int left = k;
        int n = n1 + n2;
        while(low <= high){
            int mid1 = (low+high)/2;
            int mid2 =left - mid1;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            if(mid1 < n1) r1 = array1[mid1];
            if(mid2 < n2) r2 = array2[mid2];
            if(mid1 - 1 >= 0) l1 = array1[mid1-1];
            if(mid2 - 1 >= 0) l2 = array2[mid2-1];
            if(l1 <= r2 && l2 <= r1) return Math.max(l1,l2);
            else if(l1 > r2) high = mid1 -1;
            else low = mid1 + 1;
        }
        return 0;
    }
}
