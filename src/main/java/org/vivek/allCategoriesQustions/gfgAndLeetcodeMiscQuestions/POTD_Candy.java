package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

import java.util.Arrays;

// https://www.geeksforgeeks.org/problems/candy/1
public class POTD_Candy {
    static int minCandy(int n, int ratings[]) {
        int[] resArr = new int[n];
        Arrays.fill(resArr,1);
        //fixing right neighbours
        for(int i = n-2; i >= 0; i--){
            if(ratings[i] > ratings[i+1]){
                resArr[i] = resArr[i+1] + 1;
            }
        }
        //fixing left neighbours 
        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i-1]){
                resArr[i] = Math.max(resArr[i],resArr[i-1]+1);
            }
        }
        return Arrays.stream(resArr).sum();
    }
}
