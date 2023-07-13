package org.vivek.sortingTechniques;

//mrging two sorted arrays
public class MergeSort {
    //1. divide and conquer algorithm
    //2. stable algorithm
    //3. theta(nlogn) time complexity and O(n) auxiliary space
    //4. well suited for linked list and works in O(1) auxiliary space
    //5. used in external sorting
    //6. In general for arrays, quicksort outperforms it.
    //7. merge sort is used in many standard library implementation, java8 uses both quick and merge sort depending upon the input type
    //In below program of merging two soorted arrays, time complexity is theta(m+n)
    public void merge(int[] a, int[] b, int m, int n){
        int i = 0, j = 0;
        while(i < m && j < n){
            if(a[i] <= b[j]){
                System.out.println(a[i++]);
            }else{
                System.out.println(b[j++]);
            }
        }
        while(i < m)System.out.println(a[i++]);
        while(j < n)System.out.println(b[j++]);
    }

}
