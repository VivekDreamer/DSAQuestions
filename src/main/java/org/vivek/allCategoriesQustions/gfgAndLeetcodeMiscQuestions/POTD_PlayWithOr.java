package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

// https://www.geeksforgeeks.org/problems/play-with-or5515/1
public class POTD_PlayWithOr {
    public static int[] game_with_number (int arr[], int n) {
        for(int i = 0; i < arr.length - 1; i++){
            int a = arr[i];
            int b = arr[i+1];
            int c = a | b;
            arr[i] = c;
        }
        return arr;
    }
}
