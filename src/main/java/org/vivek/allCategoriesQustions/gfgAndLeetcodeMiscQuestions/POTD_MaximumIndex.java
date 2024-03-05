package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

// https://www.geeksforgeeks.org/problems/maximum-index-1587115620/1
public class POTD_MaximumIndex {
    static int maxIndexDiff(int a[], int n) { 
        int i = 0;
        int j = n-1;
        int max = 0;
        while(i <= j){
            if(a[i] > a[j]){
                j--;
            }else{
                max = Math.max(max,j-i);
                i++;
                j = n-1;
            }
        }
        return max;
   }
}
