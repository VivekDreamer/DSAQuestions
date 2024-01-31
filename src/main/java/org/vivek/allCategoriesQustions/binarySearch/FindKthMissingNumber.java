package org.vivek.allCategoriesQustions.binarySearch;

// You are given a strictly increasing array ‘vec’ and a positive integer ‘k’. Find the ‘kth’ positive integer missing from ‘vec’.
// https://takeuforward.org/arrays/kth-missing-positive-number/
public class FindKthMissingNumber {
    // The main idea is to shift k by 1 step if the current element is smaller or equal to k. And whenever we get a number > k,
    // we can conclude that k is the missing number.
    // Brute force
    public static int missingK(int[] arr, int n, int k) {
        for(int i = 0; i < n; i++){
            if(arr[i] <= k) k++; //shifting k
            else break;
        }
        return k;
    }

    // optimal
// After completing the binary search on the indices, the pointer high will point to the closest neighbor(present in the array) that is smaller than the kth missing number. 

// So, in the given array, the preceding neighbor of the kth missing number is vec[high]. 
// Now, we know, up to index ‘high’,
// the number of missing numbers = vec[high] - (high+1).
// But we want to go further and find the kth number. To extend our objective, we aim to find the kth number in the sequence. In order to determine the number of additional missing values required to reach the kth position, we can calculate this as
// more_missing_numbers = k - (vec[high] - (high+1)).
// Now, we will simply add more_missing_numbers to the preceding neighbor i.e. vec[high] to get the kth missing number.
// kth missing number = vec[high] + k - (vec[high] - (high+1))
//         =  vec[high] + k - vec[high] + high + 1
//         = k + high + 1.
    public static int missingKOptimal(int[] arr, int n, int k){
        int low = 0;
        int high = n-1;
        while(low <= high){
            int mid = low + (high - low)/2;
            int missing = arr[mid] - (mid+1);
            if(missing < k){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return k + high + 1; // or you can also write low + k;
    }
    

    
}