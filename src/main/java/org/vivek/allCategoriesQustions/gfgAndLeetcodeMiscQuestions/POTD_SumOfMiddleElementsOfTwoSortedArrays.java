// https://www.geeksforgeeks.org/problems/sum-of-middle-elements-of-two-sorted-arrays2305/1
class POTD_SumOfMiddleElementsOfTwoSortedArrays {
    public int SumofMiddleElements(int[] a1, int[] a2) {
        // code here
        int m=a1.length;
        int n=a2.length;
        int[] a=new int[m+n];
        int i,j,k;
        i=j=k=0;
        while(i<m && j<n){
            if(a1[i]<=a2[j]){
                a[k]=a1[i];
                i++;
                k++;
            }
            else{
                a[k]=a2[j];
                j++;
                k++;
            }
        }
        while(i<m){
            a[k]=a1[i];
            i++;
            k++;
        }
        while(j<n){
            a[k]=a2[j];
            j++;
            k++;
        }
        int p=(n+m)/2;
        return a[p-1]+a[p];
    }
}
