// https://www.geeksforgeeks.org/problems/minimum-element-in-a-sorted-and-rotated-array3611/1
public class POTD_SortedAndRotatedMinimum {
    int findMin(int arr[]) {
        int n = arr.length;
        if(n == 1) return arr[0];
        int low = 0;
        int high = n-1;
        int min = Integer.MAX_VALUE;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[low] <= arr[high]){
                min = Math.min(arr[low],min);
                break;
            } else if(arr[mid] >= arr[low]){
                min = Math.min(arr[low], min);
                low = mid + 1;
            } else {
                min = Math.min(arr[mid], min);
                high = mid - 1;
            }
        }
        return min;
    }
}
