package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

// https://www.geeksforgeeks.org/problems/techfest-and-the-queue1044/1
public class POTD_TechFestAndQueue {
    public static long sumOfPowers(long a, long b) {
        long ans = 0;
        for(long i = a; i <= b; i++){
            ans += primes(i);
        }
        return ans;
    }
    public static long primes(long x){
        long ans = 0;
        for(int i = 2; i*i <= x; i++){
            while(x % i == 0){
                ans++;
                x /= i;
            }
        }
        if(x != 1) ans++;
        return ans;
    }
}
