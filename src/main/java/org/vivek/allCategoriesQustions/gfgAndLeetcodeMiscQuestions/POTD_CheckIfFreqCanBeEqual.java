package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

// https://www.geeksforgeeks.org/problems/check-frequencies4211/1
public class POTD_CheckIfFreqCanBeEqual {
    boolean sameFreq(String s) {
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        if(check(freq)){
            return true;
        }
        //reduce all ch freq one by one and then check
        for(int i = 0; i < 26; i++){
            if(freq[i] > 0){
                freq[i]--;
                if(check(freq)) return true;
                freq[i]++;
            }
        }
        return false;
    }
    boolean check(int[] freq){
        int n = -1; //get first number
        for(int f : freq){
            if(f > 0){
                if(n == -1) n = f;
                else if(n != f) return false;
            }
        }
        return true;
    }
}
