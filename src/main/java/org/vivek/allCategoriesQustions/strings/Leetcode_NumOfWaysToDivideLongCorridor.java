package org.vivek.allCategoriesQustions.strings;

import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor/
public class Leetcode_NumOfWaysToDivideLongCorridor {
    int MOD = 1000000007;
    public int numberOfWays(String corridor) {
        int n = corridor.length();
        List<Integer> posSeats = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(corridor.charAt(i) == 'S') posSeats.add(i);
        }
        if(posSeats.size() % 2 != 0 || posSeats.size() == 0){
            return 0;
        }
        long result = 1;
        int prev = posSeats.get(1); // End index of the starting subarray having 2 seats
        for(int i = 2; i < posSeats.size(); i+=2){
            int length = posSeats.get(i) - prev;
            result = (result*length) % MOD;
            prev = posSeats.get(i+1);
        }
        return (int) result;
    }
}
