package org.vivek.slidingWindow;

import java.util.HashMap;
import java.util.Map;

// Question link
// https://www.geeksforgeeks.org/count-occurrences-of-anagrams/
public class CountOccurrancesOfAnAnagram {
    public static void main(String[] args) {
        // String s = "forxxorfxdofr";
        // String p = "for";
        String s = "aabaabaa";
        String p = "aaba";
        int count = countAllOccurancesOfAnAnagram(s, p);
        System.out.println("count is : "+count);
    }
    public static int countAllOccurancesOfAnAnagram(String s, String p){
        int ans = 0;
        //create a map which will store the count of each character in the pattern
        Map<Character,Integer> map = new HashMap<>();
        for(char ch : p.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        int k = p.length();
        //retrieve the size of map which will tell the number of distinct element in the pattern
        int count = map.size();
        int i = 0; int j = 0;
        //sliding window problem
        while(j < s.length()){
            //first check the character at the jth index in string s is present in the map or not. If 
            //it is present then, the reduce the frequency of that character in the map. And after then,
            //check whether the frequency count of that character becomes 0 or not. If it becomes 0 then, 
            //reduce the overall count of distinct characters in the map.
            char ch = s.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)-1);
                if(map.get(ch) == 0) count--;
            }

            //check the window size, if it is less than k then, increament j 
            if(j-i+1 < k) j++;
            //if window size becomes equal to k then, check whether all the distinct charater count becomes 0 or not.
            //if it becomes 0 then, increase the "ans" that, we have found one anagram.
            //As we have to move the window 1 step forward then, we have to increment the frequency of character at ith index in the map
            //and check whether the frequency of that character become 1 again in the map. We have to increase the count again.
            //and then, simply do i++ and j++; 
            else if(j-i+1 == k){
                if(count == 0) ans++;
                char ch1 = s.charAt(i);
                if(map.containsKey(ch1)){
                    map.put(ch1, map.get(ch1)+1);
                    if(map.get(ch1) == 1) count++;
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}
