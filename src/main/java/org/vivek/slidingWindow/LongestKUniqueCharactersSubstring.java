package org.vivek.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestKUniqueCharactersSubstring {
    public static void main(String[] args) {
        String s = "aabacbebebe"; int k = 3;
        int longestkSubstr = longestkSubstr(s, k);
        System.out.println("result is : "+longestkSubstr);
    }
    public static int longestkSubstr(String s, int k) {
        int len = s.length();
        int answer = -1;
        int i = 0; int j = 0;
        //map to store frequency of each character
        Map<Character,Integer> map = new HashMap<>();
        while(j < len){
            //sliding window calculations
            char ch = s.charAt(j);
            //increase the frequency of character in map by 1
            map.put(ch, map.getOrDefault(ch, 0)+1);
            /* Sliding Window Condition: hashmap.size = k  [OR number of Unique Characters =k];
            Reduce the frequency of ith element by 1 and remove it from map if frequency becomes 0.
            Keep doing above [reducing window size] till hm.size becomes <=k */
            if(map.size() > k){
                while(map.size() > k){
                    char iChar = s.charAt(i);
                    map.put(iChar, map.get(iChar)-1);
                    if(map.get(iChar) == 0) map.remove(iChar);
                    i++;
                }
            }
            //unique chars = k , compute candidate answer.
            if(map.size() == k){
                int currAnswer = j-i+1;
                answer = Math.max(answer, currAnswer);
            }
             // increase window size and look for next window where sum = target
            j++;
        }
        return answer;
    }
}
