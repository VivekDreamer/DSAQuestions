package org.vivek.sortingTechniques;

import java.util.Arrays;

public class UnionOfTwoSortedArray {
    public static void main(String[] args) {
        int a[] = new int[]{3,8,10};
        int b[] = new int[]{2,8,9,10,15};
        
        int m = a.length;
        int n = b.length;
        union(a, b, m, n);
    }
    public static void union(int[] a, int[] b, int m, int n){
        int[] c = new int[m+n];
        for(int i = 0; i < m; i++) c[i] = a[i];
        for(int i = 0; i < n; i++) c[i+m] = b[i];
        Arrays.sort(c);
        for(int i = 0; i < m+n; i++){
            if(i == 0 || c[i] != c[i-1])
                System.out.print(c[i]+" ");
        }
    }
    public static void unionEfficient(int[] a, int[] b, int m, int n){
        int i = 0, j = 0;
        while(i < m && j < n){
            if(i > 0 && a[i] == a[i-1]){i++; continue;}
            if(j > 0 && b[j] == b[j-1]){j++; continue;}
            if(a[i] < b[j]){System.out.print(a[i]); i++;}
            else if(a[i] > b[j]){System.out.print(b[j]); j++;}
            else {System.out.print(a[i]);i++;j++;}
        }
        while(i < m){
            if(i > 0 && a[i] == a[i-1]) System.out.print(a[i]+" ");
        }
        while(j < n){
            if(i > 0 && a[i] == a[i-1]) System.out.print(a[i]+" ");
        }
    }
}
