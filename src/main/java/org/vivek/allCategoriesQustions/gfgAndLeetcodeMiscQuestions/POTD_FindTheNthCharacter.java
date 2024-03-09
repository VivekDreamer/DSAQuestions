package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

// https://www.geeksforgeeks.org/problems/find-the-n-th-character5925/1
public class POTD_FindTheNthCharacter {
    public char nthCharacter(String s, int r, int n){
        for(int i = 0; i < r; i++){
            StringBuilder curr = new StringBuilder();
            for(char ch : s.toCharArray()){
                if(ch == '0'){
                    curr.append("01");
                }else if(ch == '1'){
                    curr.append("10");
                }
                if(curr.length() > n) break;
            }
            s = curr.toString();
        }
        return s.charAt(n);
    }
}
