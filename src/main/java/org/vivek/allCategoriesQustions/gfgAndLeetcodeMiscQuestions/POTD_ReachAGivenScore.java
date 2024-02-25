package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

import java.util.Arrays;

// https://www.geeksforgeeks.org/problems/reach-a-given-score-1587115621/1
public class POTD_ReachAGivenScore {
    public long count(int n) {
        long[] arr = new long[n+1];
        Arrays.fill(arr,0);
        arr[0] = 1;
        for(int i = 3; i <= n; i++){
            arr[i]+=arr[i-3];
        }
        for(int i = 5; i <= n; i++){
            arr[i]+=arr[i-5];
        }
        for(int i = 10; i <= n; i++){
            arr[i]+=arr[i-10];
        }
        return arr[n];
    }
}
