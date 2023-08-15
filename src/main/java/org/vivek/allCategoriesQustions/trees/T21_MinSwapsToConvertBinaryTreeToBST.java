package org.vivek.allCategoriesQustions.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// https://practice.geeksforgeeks.org/problems/minimum-swap-required-to-convert-binary-tree-to-binary-search-tree/0?page=1&sortBy=newest&query=page1sortBynewest
// same problem as that of minimuum swaps required to make an array sorted.
public class T21_MinSwapsToConvertBinaryTreeToBST {
    public static void main(String[] args) {
        int arr[] = { 5, 6, 7, 8, 9, 10, 11 };
        int minSwaps = minSwaps(arr.length, arr);
        System.out.println("minimum number of swaps : "+minSwaps);
    }

    private static int minSwaps(int n, int[] arr) {
        List<Integer> list = new ArrayList<>();
        inorder(arr,list,0);
        return countSwaps(list);
    }

    private static int countSwaps(List<Integer> list) {
        int n = list.size();
        Pair[] pair = new Pair[n];
        for(int i = 0; i < n; i++){
            pair[i] = new Pair(list.get(i), i);
        }
        int count = 0;
        Arrays.sort(pair,new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Integer.compare(o1.element, o2.element);
            }
        });
        for(int i = 0; i < n; i++){
            if(i == pair[i].index){
                continue;
            }else{
                count++;
                swap(pair,i,pair[i].index);
                i--;
            }
        }
        return count;
    }

    private static void swap(Pair[] pair, int i, int index) {
        int tempElement = pair[i].element;
        int tempIndex = pair[i].index;
        pair[i].element = pair[index].element;
        pair[i].index = pair[index].index;
        pair[index].element = tempElement;
        pair[index].index = tempIndex;
    }
    
    private static void inorder(int[] arr, List<Integer> list, int i) {
        if(i >= arr.length) return;
        inorder(arr, list, 2*i+1);
        list.add(arr[i]);
        inorder(arr, list, 2*i+2);
    }

    static class Pair{
        int element;
        int index;
        public Pair(int element, int index) {
            this.element = element;
            this.index = index;
        }
    }
}
