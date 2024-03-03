package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

import java.util.Arrays;
import java.util.Comparator;

// https://www.geeksforgeeks.org/problems/largest-number-formed-from-an-array1117/1
public class POTD_LargestNumberFormedFromAnArray {
    String printLargest(int n, String[] arr) {
        Arrays.sort(arr, new Comparator<String>(){
            @Override public int compare(String a, String b){
                String ab = a+b;
                String ba = b+a;
                return ba.compareTo(ab);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String str : arr){
            sb.append(str);
        }
        return sb.toString();
    }
}
