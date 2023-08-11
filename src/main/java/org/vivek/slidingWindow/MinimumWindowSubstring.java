package org.vivek.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        // String s = "ADOBECODEBANC", t = "ABC";
        String s = "a", t = "a";
        String ans = minWindow(s, t);
        System.out.println(ans);
    }
    public static String minWindow(String s, String t) {
        int n = s.length();
        String ans = "";
        int i = 0; int j = 0;
        Map<Character,Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for(char ch : t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        int count = map.size();
        while(j < n){
            char ch = s.charAt(j);
            if(!map.containsKey(ch)){
                j++;
                continue;
            } else if(map.containsKey(ch)){
                map.put(ch, map.get(ch)-1);
                if(map.get(ch) == 0) count--;
            }
            if(count == 0){
                if(min > j-i+1){
                    ans = s.substring(i, j+1);
                    min = Math.min(min,j-i+1);
                }
                while(count == 0){
                    char ichar = s.charAt(i);
                    if(!map.containsKey(ichar)){
                        i++;
                    }else{
                        map.put(ichar, map.get(ichar)+1);
                        if(map.get(ichar) > 0) count++;
                        i++;
                    }
                    if(count==0)
                    {
                        if(min>j-i+1)
                        {
                            ans=s.substring(i,j+1);
                            min=j-i+1;
                        }
                    }
                }
            }
            j++;
        }
        return ans;
    }
}
