package org.vivek.allCategoriesQustions.arrays;

public class A36_MedianOfTwoSortedArray {
    public static void main(String[] args) {
        int n = 3, m = 4;
        int array1[] = {1,5,9};
        int array2[] = {2,3,6,7};
        double medianOfArrays = medianOfArrays(n, m, array1, array2);
        System.out.println("median Of Arrays : "+medianOfArrays);
    }
    public static double medianOfArrays(int n, int m, int a[], int b[]) 
    {
        //n = a.length
        //m = b.length
        int[] res = new int[n+m];
        int i = 0, j = 0, k = 0;
        while(i < n && j < m){
            if(a[i] < b[j]){
                res[k] = a[i];
                i++;
            }
            else{
                res[k] = b[j];
                j++;
            }
            k++;
        }
        while(i < n) res[k++] = a[i++];
        while(j < m) res[k++] = b[j++];
        i = k/2;
        return (k % 2 == 0) ? (double)(res[i]+res[i-1])/2 : (double)(res[i]);
    }
}
