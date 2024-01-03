package org.vivek.allCategoriesQustions.amazonQuestions;

// https://www.geeksforgeeks.org/problems/max-sum-in-the-configuration/1
public class MaxSumInTheConfiguration {
    public int maxSum(int[] arr, int n){
        int sum = 0;
        int S0 = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
            S0 += (arr[i] * i);
        }
        int max = sum;
        int Si = S0;
        for(int i = 0; i < n-1; i++){
            int Sip1 = Si + sum - n * arr[n-i-1];
            if(Sip1 > max){
                max = Sip1;
            }
            Si = Sip1;
        }
        return max;
    }
}
