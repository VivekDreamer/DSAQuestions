// https://www.geeksforgeeks.org/problems/move-all-zeroes-to-end-of-array0751/1
public class POTD_MoveAllZeroesToEnd {
    void pushZerosToEnd(int[] arr) {
        int l = arr.length;
        int idx = -1;
        for (int i = 0; i < l; i++) {
            if (arr[i] == 0 && idx == -1) {
                idx = i;
            } else if (arr[i] != 0 && idx != -1) {
                arr[idx] = arr[i];
                arr[i] = 0;
                idx++; 
            }
        }
    }
}
