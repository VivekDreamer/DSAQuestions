package org.vivek.dp.mcm;

import java.util.HashMap;
//https://www.interviewbit.com/problems/scramble-string/
public class ScrambleString {
    public static void main(String[] args) {
        String a = "great";
        String b = "rgeat";
        System.out.println(isScramble(a, b));
    }
    public static int isScramble( String a, String b) {
        if(a.isEmpty() && b.isEmpty()) return 1;
        HashMap<String,Boolean> map = new HashMap<>();
        return isScrambled(a,b,map)?1:0;
    }
    private static boolean isScrambled(String a, String b, HashMap<String, Boolean> map) {
        if(a.equals(b)) return true;
        if(a.length() <= 1) return false;
        int n = a.length();
        String key = a+" "+b;
        if(map.containsKey(key)) return (boolean)map.get(key);
        boolean flag=false;
        for(int j=1;j<n;j++){
            if(isScrambled(a.substring(0,j),(b.substring(n-j,n)),map) && isScrambled(a.substring(j,n),b.substring(0,n-j),map)){
                flag=true;
                break;
            }
            if(isScrambled(a.substring(0,j),(b.substring(0,j)),map) && isScrambled(a.substring(j),b.substring(j),map)){
                flag=true;
                break;
            }
        }
        map.put(key,flag);
        return flag;
    }
}
