// https://www.geeksforgeeks.org/problems/second-largest3735/1
public class POTD_SecondLargest {
    public int getSecondLargest(int[] arr) {
        // int largest = -1;
        // int secondLargest = -1;
        // for(int i = 0; i < arr.length; i++) {
        //     if(arr[i] > largest){
        //         secondLargest = largest;
        //         largest = arr[i];
        //     } if(arr[i] > secondLargest && largest != arr[i]) {
        //         secondLargest = arr[i];
        //     }
        // }
        // return (secondLargest == -1) ? -1 : secondLargest;
        
        int largest = Arrays.stream(arr).max().getAsInt();
        int secondLargest = -1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }
}
