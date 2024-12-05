// https://www.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1
public class POTD_Sort012{
    public void sort012(int[] arr) {
        int low = 0, mid = 0, high = n-1;
        while(mid <= high){
            if(arr[mid] == 0){
                swap(arr,low,mid);
                low++;
                mid++;
            }else if(arr[mid] == 1){
                mid++;
            } else if(arr[mid] == 2){
                swap(arr,mid,high);
                high--;
            }
        }
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
