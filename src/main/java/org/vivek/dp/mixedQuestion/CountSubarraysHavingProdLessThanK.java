package org.vivek.dp.mixedQuestion;
//https://practice.geeksforgeeks.org/problems/count-the-subarrays-having-product-less-than-k1708/1
public class CountSubarraysHavingProdLessThanK {
    public static void main(String[] args) {
        int n = 4, k = 10; long a[] = {1, 2, 3, 4};
        int countSubArrayProductLessThanK = countSubArrayProductLessThanK(a, n, k);
        System.out.println(countSubArrayProductLessThanK);
    }   
    public static int countSubArrayProductLessThanK(long a[], int n, long k)
    {
        //resembles with sliding window
        if(k <= 1) return 0;
        int result = 0;
        int prod = 1;
        int left = 0;
        int right = 0;
        while(right < n){
            prod*=a[right];
            while(prod>=k){
                prod/=a[left];
                left++;
            }
            result+=(right-left+1);
            right++;
        }
        return result;
    } 
}
