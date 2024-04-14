// https://geeksforgeeks.org/problems/xoring-and-clearing/1
class POTD_XoringAndClearing {
    public void printArr(int n, int arr[]) {
        for(int num : arr){
            System.out.print(num+" ");
        }
        System.out.println();
    }

    public void setToZero(int n, int arr[]) {
        Arrays.fill(arr,0);
    }

    public void xor1ToN(int n, int arr[]) {
       for(int i = 0; i < n; i++){
           arr[i] = arr[i]^i;
       }
    }
}
