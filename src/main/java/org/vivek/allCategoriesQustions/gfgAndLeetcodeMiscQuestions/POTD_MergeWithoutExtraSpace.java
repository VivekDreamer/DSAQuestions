// https://www.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1
public class POTD_MergeWithoutExtraSpace
{
    //Function to merge the arrays.
    public void mergeArrays(int a[], int b[]) {
        int n = a.length;
        int m = b.length;
        int left = n-1;
        int right = 0;
        while(left >= 0 && right < m){
            if(a[left] > b[right]){
                int temp = a[left];
                a[left] = b[right];
                b[right] = temp;
                left--;
                right++;
            } else break;
        }
        Arrays.sort(a);
        Arrays.sort(b);
    }
}
