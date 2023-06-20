package org.vivek.dp.mixedQuestion;
//https://practice.geeksforgeeks.org/problems/assembly-line-scheduling/1
public class AssemblyLineScheduling {
    public static void main(String[] args) {
        int N = 4;
        int a[][] = {{4, 5, 3, 2}, 
                     {2, 10, 1, 4}};    //time at each station in assembly line 0 and 1
        int T[][] = {{0,7, 4, 5},
                     {0,9, 2, 8}};      //cross time at each station in assembly line 0 and 1
        int e[] = {10,12}; //starting time 
        int x[] = {18,7};  //ending time
        int min = carAssembly(N,a,T,e,x);
        System.out.println(min);
    }

    private static int carAssembly(int n, int[][] a, int[][] t, int[] e, int[] x) {
        int T1[] = new int[n];
        int T2[] = new int[n];
        T1[0] = e[0] + a[0][0];
        T2[0] = e[1] + a[1][0];
        for(int i = 1; i < n; i++){
            T1[i] = Math.min(T1[i-1] + a[0][i] , T2[i-1] + a[0][i] + t[1][i]);
            T2[i] = Math.min(T2[i-1] + a[1][i] , T1[i-1] + a[1][i] + t[0][i]);
        }
        int minTime = Math.min(T1[n-1] + x[0] , T2[n-1] + x[1]);
        return minTime;
    }
}
