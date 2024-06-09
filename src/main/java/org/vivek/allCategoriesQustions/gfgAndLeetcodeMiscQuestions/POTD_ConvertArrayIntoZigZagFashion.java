// https://www.geeksforgeeks.org/problems/convert-array-into-zig-zag-fashion1638/1
class POTD_ConvertArrayIntoZigZagFashion {
    public static void zigZag(int n, int[] arr) {
        for(int i = 0; i < n-1; i++){
            if(i % 2 == 0){
                //make sure that this element should be smaller than next index element,if not then swap it
                if(arr[i] > arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            } else{
                //make sure that this element should be larger than next index element, if not then swap it.
                if(arr[i] < arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
    }
}
