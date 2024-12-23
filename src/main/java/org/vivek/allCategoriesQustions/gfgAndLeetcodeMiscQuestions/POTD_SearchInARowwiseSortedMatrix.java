// https://www.geeksforgeeks.org/problems/search-in-a-row-wise-sorted-matrix/1
public class POTD_SearchInARowwiseSortedMatrix {
    public boolean searchRowMatrix(int[][] mat, int x) {
        int m = mat[0].length;
        for(int[] arr : mat) if(bst(arr,m,x)) return true;
        return false;
    }
    private boolean bst(int[] arr, int n, int x) { 
        int left = 0;
        int right = n-1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(arr[mid] == x) return true;
            else if(arr[mid] < x) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}
