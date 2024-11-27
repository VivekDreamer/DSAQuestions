// https://www.geeksforgeeks.org/problems/smallest-positive-missing-number-1587115621/1
public class POTD_SmallestPositiveMissingNumber{
    static int missingNumber(int arr[]){
        int size = arr.length;
        boolean hasOne = false;
        for(int i = 0; i < size; i++){
            if(arr[i] == 1) hasOne = true;
            if(arr[i] <= 0 || arr[i] > size) arr[i] = 1; 
        }
        if(!hasOne) return 1;
        for(int i = 0; i < size; i++){
            int num = Math.abs(arr[i]);
            int idx = num-1;
            if(arr[idx] < 0) continue;
            arr[idx] *= -1;
        }
        for(int i = 0; i < size; i++){
            if(arr[i] > 0) return i+1;
        }
        return size+1;
    }
}
