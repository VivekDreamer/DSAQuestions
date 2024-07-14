// https://www.geeksforgeeks.org/problems/segregate-0s-and-1s5106/1
class POTD_Segregate0sAnd1s {
    void segregate0and1(int[] arr) {
        int length = arr.length;
        int j = 0;   //using j to start from the beginning of array
        
        for(int i = 1; i < arr.length; i++){
            // if we encounter a 0, then we will just increment the value of j.
            if(arr[j] == 0){
                j++;
            }
            // but if we encounter 1 and then next value is 0 then we need to swap the values
           // so that 0 comes to the left of the array and 1 goes towards the right.
            if(arr[j] == 1 && arr[i] == 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
}
}
