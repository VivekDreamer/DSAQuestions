package org.vivek.dp.mixedQuestion;

import java.util.Arrays;
//https://practice.geeksforgeeks.org/problems/friends-pairing-problem5425/1
// if this solution doesn't submit for large test cases, just take mod
// here we have two choices:
// either we can go with single and call for remaining (n-1) friends
// or we can have the choice to pair it with (n-1) friends and call for (n-2) friends
// recurrance relation = fun(n-1) + (n-1)fun(n-2);
public class FriendsPairingProblelm {
    public static void main(String[] args) {
        int n = 3;
        long countFriendsPairings = countFriendsPairings(n);
        System.out.println(countFriendsPairings);
    }
    public static long countFriendsPairings(int n) {
        long[] memo = new long[n+1];
        Arrays.fill(memo,-1);
        return countFriendsPairingsUtil(n,memo);
    }
    private static long countFriendsPairingsUtil(int n, long[] memo) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(memo[n] != -1) return memo[n];
        long a = countFriendsPairingsUtil(n-1,memo);
        long b = (n-1)*countFriendsPairingsUtil(n-2, memo);
        return memo[n] = a+b;
    }
}
