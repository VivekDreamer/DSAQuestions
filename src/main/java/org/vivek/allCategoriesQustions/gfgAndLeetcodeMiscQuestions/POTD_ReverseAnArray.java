// https://www.geeksforgeeks.org/problems/reverse-an-array/1
public class POTD_ReverseAnArray {
    public void reverseArray(int arr[]) {
        int len = arr.length;
        for(int i = 0;i < len/2;i++){
            int temp = arr[i];
            arr[i] = arr[len-i-1];
            arr[len-i-1] = temp;
        }
    }
}
