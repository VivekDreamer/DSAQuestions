package org.vivek.allCategoriesQustions.bitmanipulation;
//some facts:
//1. How to find the ith bit of a number:
//   (num >> i) & 1 = 1
//   eg. 0 1 0 1 0 
//      find 3rd bit whether it is 0 or 1... just right shift the above number by i i.e, it will become as
//      (0 0 0 0 1) & 1 
//      if result of above operation came as 1 then the 3rd bit is 1 otherwise it is 0       
//2. How to unset the rightmost set bit of an integer?
//   n = (n & (n-1))

//https://leetcode.com/problems/number-of-1-bits/
public class Leetcode_HammingWeight {
    //Approach 1
    // Approach-1 (Using simple right shift operator)
    // T.C : O(1) - because the loop in the code iterates 32 times, which is a constant number regardless of the input n
    // S.C : O(1)
    public int hammingWeight(int n) {
        int count = 0;
        for(int i = 31; i >= 0; i--){
            if(((n>>i) & 1) == 1) count++;
        }
        return count;
    }

    //Approach 2
    // Approach-2 (Using simple bit magic)
    // T.C : O(k) -> Where k = number of set bits (1s) in input 'n'
    // S.C : O(1)
    public int hammingWeight1(int n) {
        int count = 0;
        while (n != 0) {
            // This expression is used to turn off the rightmost set bit in n. This operation effectively removes one set bit in each iteration.
            n = n & (n - 1); 
            count++;
        }
        return count;
    }

    //Approach 3
    // Approach-3 (Using simple bit magic)
    // T.C : O(log(n)) -> In each iteration, n is divided by 2 (n /= 2)
    // S.C : O(1)
    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            count += (n % 2);
            n /= 2;
        }
        return count;
    }

    //Approach 4
    // Approach-4 (using built-in Java function)
    // T.C : O(k) -> Where k = number of set bits (1s) in input 'n'
    // S.C : O(1)
    public int hammingWeight3(int n) {
        return Integer.bitCount(n);
    }
}
