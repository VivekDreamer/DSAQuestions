package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

// https://www.geeksforgeeks.org/problems/transform-to-prime4635/1
public class POTD_TransformToPrime {
    public int minNumber(int arr[], int N)
    {
        int sum = 0;
        for(int i = 0; i < N; i++){
            sum+=arr[i];
        }
        return nextPrime(sum) - sum;
    }
    
    public boolean isPrime(int n){
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        return true;
    }
    
    public int nextPrime(int n){
        if(n <= 2) return 2;
        if(n % 2 == 0) n++;
        // only odds can be prime for n>2
        // and a prime will exist between n and 2n
        for(int i = n; i <= 2*n; i++){
            if(isPrime(i)) return i;
        }
        return n;
    }
}
