// https://www.geeksforgeeks.org/problems/next-permutation5226/1
public class POTD_NextPermutation {
    void nextPermutation(int[] arr) {
        int i, n = arr.length;
        for(i = n-2; i >= 0; i--){
            if(arr[i] < arr[i+1]) break;
        }
        if(i > -1){
            int nextMax = Integer.MAX_VALUE, nextPos = 0;
            for(int j = i+1; j < n; j++){
                if(arr[j] > arr[i] && arr[j] < nextMax){
                    nextMax = arr[j];
                    nextPos = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[nextPos];
            arr[nextPos] = temp;
            reverse(arr, i+1, n-1);
        }
        else{
            reverse(arr, 0, n-1);
        }
    }
    void reverse(int[] arr, int i, int j){
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
