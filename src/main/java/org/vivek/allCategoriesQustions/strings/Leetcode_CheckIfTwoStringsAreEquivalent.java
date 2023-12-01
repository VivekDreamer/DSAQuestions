package org.vivek.allCategoriesQustions.strings;

//https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
public class Leetcode_CheckIfTwoStringsAreEquivalent {
    //Approach 1 
    //Naive Approach
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        for (String s : word1) s1.append(s);
        for (String s : word2) s2.append(s);
        return s1.toString().equals(s2.toString());
    }

    //Approach 2
    //Approach related with indexes
    public boolean arrayStringsAreEqual1(String[] word1, String[] word2) {
        int m = word1.length;
        int n = word2.length;
        int w1i = 0, w2i = 0; //representing the words in the array
        int i = 0, j = 0;
        while(w1i < m && w2i < n){
            if(word1[w1i].charAt(i) != word2[w2i].charAt(j)) return false;
            i++;
            j++;
            if(i == word1[w1i].length()){
                i = 0;
                w1i++;
            }
            if(j == word2[w2i].length()){
                j = 0;
                w2i++;
            }
            if(w1i == m && w2i == n) return true;
        }
        return false;
    }
}
