package org.vivek.allCategoriesQustions.arrays;

import java.util.ArrayList;

// https://www.geeksforgeeks.org/problems/pascal-triangle0652/1
public class POTD_PascalTriangle {
    ArrayList<Long> nthRowOfPascalTriangle(int n) {
        ArrayList<Long> res = new ArrayList<>();
        long MOD = 1000000007;
        for(int i = 0; i < n; i++){
            ArrayList<Long> current = new ArrayList<>();
            for(int j = 0; j < i+1; j++){
                if(j == i || j == 0)
                    current.add(1l);
                else{
                    long num = (res.get(j) + res.get(j-1)) % MOD;
                    current.add(num);
                }
            }
            res = current;
        }
        return res;
    }
}
