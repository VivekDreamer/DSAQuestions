package org.vivek.allCategoriesQustions.amazonQuestions;

import java.util.PriorityQueue;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/kth-element-in-matrix/1
public class KthElementInMatrix {

    public static int kthSmallest(int[][]matrix,int n,int k){
        Queue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                queue.add(matrix[i][j]);
                if(queue.size() > k){
                    queue.poll();
                }
            }
        }
        return queue.peek();
    }

    // reference:
    // https://www.youtube.com/watch?v=HuOcDlB1uXk&t=98s
    public static int kthSmallest1(int[][]matrix,int n,int k){
        int requiredSmallerElements = k-1;
        int start = matrix[0][0];
        int end = matrix[n-1][n-1];
        while(start <= end){
            int assumedKthElement = start + (end - start)/2;
            int smallerElements = findSmallerElements(matrix, assumedKthElement);
            if(smallerElements <= requiredSmallerElements) start = assumedKthElement + 1;
            else end = assumedKthElement - 1;
        }
        return start;
    }

    private static int findSmallerElements(int[][] matrix, int assumedKthElement) {
        int numberOfSmallerElements = 0;
        for(int i = 0; i < matrix.length; i++){
            int start = 0;
            int end = matrix[i].length;
            while (start <= end) {
                int mid = start + (end - start)/2;
                if(matrix[i][mid] <= assumedKthElement)
                    start = mid+1;
                else
                    end = mid-1;
            }
            numberOfSmallerElements += start;
        }
        return numberOfSmallerElements;
    }
}
