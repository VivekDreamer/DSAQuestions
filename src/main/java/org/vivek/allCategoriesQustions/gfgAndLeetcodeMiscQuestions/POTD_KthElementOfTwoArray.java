// https://www.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1
class POTD_KthElementOfTwoArray {
    public long kthElement(int k, int arr1[], int arr2[]) {
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
