// https://www.geeksforgeeks.org/problems/index-of-an-extra-element/1
class POTD_IndexOfAnExtraElement {
    public int findExtra(int n, int arr1[], int arr2[]) {
        int l=0,r=n-1;
        while(l<r){
            int mid=l+(r-l)/2;
            if(arr1[mid]<arr2[mid]) r=mid;
            else if(arr1[mid]==arr2[mid]) l=mid+1;
        }
        return r;
    }
}
