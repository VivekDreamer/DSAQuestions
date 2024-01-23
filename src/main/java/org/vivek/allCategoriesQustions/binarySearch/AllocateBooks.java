package org.vivek.allCategoriesQustions.binarySearch;

import java.util.Arrays;

public class AllocateBooks {
    public static int findPagesBruteForce(int[] arr, int n, int m) {
        // book allocation impossible
        if (m > n)
            return -1;

        int low = Arrays.stream(arr).max().orElseThrow();
        int high = Arrays.stream(arr).sum();

        for (int pages = low; pages <= high; pages++) {
            if (countStudents(arr, pages) == m) {
                return pages;
            }
        }
        return low;
    }

    //optimal
//     If students > m: On satisfying this condition, we can conclude that the number ‘mid’ is smaller than our answer. So, we will eliminate the left half and consider the right half(i.e. low = mid+1).
//     Otherwise, the value mid is one of the possible answers. But we want the minimum value. So, we will eliminate the right half and consider the left half(i.e. high = mid-1).
    private static int findPages(int[] arr, int n, int numOfStudents){
        if(n < numOfStudents) return -1;
        int low = Arrays.stream(arr).max().orElseThrow();
        int high = Arrays.stream(arr).sum();
        while (low <= high) {
            int mid = low + (high - low)/2;
            int students = countStudents(arr,mid);
            if(students > numOfStudents) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }

    private static int countStudents(int[] arr, int mid) {
        int student = 1;
        int pagesStudent = 0;
        for(int i = 0; i < arr.length; i++){
            if(pagesStudent + arr[i] <= mid){
                pagesStudent += arr[i];
            } else {
                student += 1;
                pagesStudent = arr[i];
            }
        }
        return student;
    }
}
