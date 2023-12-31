package org.vivek.allCategoriesQustions.amazonQuestions.midLevelQuestions;

// https://www.geeksforgeeks.org/problems/interleaved-strings/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
public class InterleavingStrings {

    int m, n, N;
    Boolean[][] memo;
    public boolean isInterLeave(String a, String b, String c){
        m = a.length();
        n = b.length();
        N = c.length();
        memo = new Boolean[m+1][n+1];
        if(m+n != N) return false;
        return isInterLeaveUtil(0, 0, a, b, c);
    }
    private boolean isInterLeaveUtil(int i, int j, String a, String b, String c) {
        if(i == a.length() && j == b.length() && i+j == N) return true;
        if(i+j >= N) return false;
        if(memo[i][j] != null) return memo[i][j];
        boolean result = false;
        if(i < m && a.charAt(i) == c.charAt(i+j)){
            result = isInterLeaveUtil(i+1, j, a, b, c);
        }
        if(result == true) return memo[i][j] = true;
        if(j < n && b.charAt(j) == c.charAt(i+j)){
            result = isInterLeaveUtil(i, j+1, a, b, c);
        }
        return memo[i][j] = result;
    }

    /*
    int m, n, N;
    public boolean isInterLeave(String a, String b, String c){
        m = a.length();
        n = b.length();
        N = c.length();
        return isInterLeaveUtil(0 ,0, 0, a, b, c);
    }
    private boolean isInterLeaveUtil(int i, int j, int k, String a, String b, String c) {
        if(i == a.length() && j == b.length() && k == c.length()) return true;
        if(k >= c.length()) return false;
        boolean result = false;
        if(i < m && a.charAt(i) == c.charAt(k)){
            result = isInterLeaveUtil(i+1, j, k+1, a, b, c);
        }
        if(result == true) return true;
        if(j < n && b.charAt(j) == c.charAt(k)){
            result = isInterLeaveUtil(i, j+1, k+1, a, b, c);
        }
        return result;
    }
    */
}
