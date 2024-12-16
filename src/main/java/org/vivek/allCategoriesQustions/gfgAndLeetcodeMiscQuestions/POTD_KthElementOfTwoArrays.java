// https://www.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1
public class POTD_KthElementOfTwoArrays {
    public int kthElement(int arr1[], int arr2[], int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i : arr1){
            arr.add(i);
        }
        for(int i : arr2){
            arr.add(i);
        }
        Collections.sort(arr);
        return arr.get(k - 1);
    }
}
