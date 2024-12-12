// https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1
public class POTD_NumberOfOccurance {
    int countFreq(int[] arr, int target) {
        // code here
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == target){
                count++;
            }
        }
        return count;
    }
}
