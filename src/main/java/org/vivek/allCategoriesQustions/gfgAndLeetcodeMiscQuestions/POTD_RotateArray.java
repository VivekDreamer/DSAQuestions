// https://www.geeksforgeeks.org/problems/rotate-array-by-n-elements-1587115621/1
public class POTD_RotateArray {
    // Function to rotate an array by d elements in counter-clockwise direction.
    static void reverse(int start, int end, int arr[]){
        while(start<=end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    static void rotateArr(int arr[], int d) {
        // add your code here
        int m = d%arr.length;
            reverse(0,m-1,arr);
            reverse(m,arr.length-1,arr);
            reverse(0,arr.length-1,arr);
        }
}
