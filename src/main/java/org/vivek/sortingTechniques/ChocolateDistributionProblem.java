package org.vivek.sortingTechniques;

import java.util.Arrays;

public class ChocolateDistributionProblem {
    public static void main(String[] args) {
        int arr[] = new int[]{7,3,2,4,9,12,56};
        int n = arr.length;
        //number of childrens
        //given an array of chocolate packets
        //you have to distribute the chocolate to the m number of students such that diffrence between minimum chocolate a child gets and 
        //maximum chocolate a child gets is minimum
        //in this we will distribute the chocolate among three children like below :
        //2,3,4 = (4-2) = 2
        int m=3;
        System.out.print(minDiff(arr,n,m));
    }

    private static int minDiff(int[] arr, int n, int m) {
        //if number of children is greater than the number of chocolate packets in the array 
        if(m > n) return -1;
        Arrays.sort(arr);
        int res = arr[m-1]-arr[0];
        for(int i = 1; (i+m-1) < n; i++){
            res = Math.min(res, arr[i+m-1]-arr[i]);
        }
        return res;
    }
}
