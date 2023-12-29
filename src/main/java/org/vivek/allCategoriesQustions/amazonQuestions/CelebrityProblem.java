package org.vivek.allCategoriesQustions.amazonQuestions;

import java.util.Stack;

// https://www.geeksforgeeks.org/problems/the-celebrity-problem/1
public class CelebrityProblem {
    public int celebrity(int[][] arr, int n){
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            stack.push(i);
        }

        while(stack.size() >= 2){
            int i = stack.pop();
            int j = stack.pop();
            if(arr[i][j] == 1){
                //mean i knows j, i.e, i is not the celebrity
                stack.push(j);
            } else {
                stack.push(i);
            }
        }

        int potentialCelebrity = stack.pop();
        for(int i = 0; i < arr.length; i++){
            if(i != potentialCelebrity){
                if(arr[i][potentialCelebrity] == 0 || arr[potentialCelebrity][i] == 1) return -1;
            }
        }
        return potentialCelebrity;
    }
}
