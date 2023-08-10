package org.vivek.slidingWindow;
import java.util.HashMap;
import java.util.Map;

public class LongestDistinctCharactersInString {
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        int longestSubstrDistinctChars = longestSubstrDistinctChars(s);
        System.out.println("result : "+longestSubstrDistinctChars);
    
    }
    public static int longestSubstrDistinctChars(String s){
        int n = s.length();
        int i = 0; int j = 0;
        int ans = -1;
        Map<Character, Integer> map = new HashMap<>();
        while(j < n){
            //first of all add the character and their frequency in the map
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            //if size of map and window size is equal then, update the answer by selecting the max ans
            if(map.size() == j-i+1){
                ans = Math.max(ans, map.size());
            }
            //if size of map is smaller than the window size then, it is confirmed that atleast one character is repeating in the window.
            else if(map.size() < j-i+1){
                //now we run loop till map size is not equal to the window size and will move the i pointer by decreamenting it's frequency
                //if frequency of that particular character becomes 0 then, remove that character from the map.
                while(map.size() < j-i+1){
                    char ichar = s.charAt(i);
                    map.put(ichar, map.get(ichar)-1);
                    if(map.get(ichar) == 0) map.remove(ichar);
                    i++;
                }
            }
            //any which ways j will be increamented..
            j++;
        }
        return ans;
    }
}
