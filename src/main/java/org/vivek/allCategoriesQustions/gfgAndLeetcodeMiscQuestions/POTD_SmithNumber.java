package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

//https://www.geeksforgeeks.org/problems/smith-number4132/1
public class POTD_SmithNumber {
    static int smithNum(int n) {
        int sumOfPrimeFactors = 0;
        int k = n;
        int digitSum = digitSum(n);
        for(int i = 2; i <= Math.sqrt(n); i++){
            while(n % i == 0){
                sumOfPrimeFactors += digitSum(i);
                n/=i;
            }
        }
        if(n > 1 && n != k){
            sumOfPrimeFactors+=digitSum(n);
        }
        return sumOfPrimeFactors == digitSum ? 1 : 0;
    }
    static int digitSum(int n){
        int temp = n;
        int ans = 0;
        while(temp != 0){
            ans += (temp % 10);
            temp /= 10;
        }
        return ans;
    }
}
