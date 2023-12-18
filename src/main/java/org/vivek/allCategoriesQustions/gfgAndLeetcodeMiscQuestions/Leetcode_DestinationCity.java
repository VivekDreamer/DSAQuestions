package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/destination-city/
class Leetcode_DestinationCity {
  public String destCity(List<List<String>> paths) {
        Map<String, Integer> mp = new HashMap<>();
        
        for(List<String> path : paths) {
            String source = path.get(0); // outdegree
            mp.put(source, mp.getOrDefault(source, 0) + 1);
        }
        
        for(List<String> path : paths) {
            String dest = path.get(1);
            
            if(mp.getOrDefault(dest, 0) == 0) {
                return dest;
            }
        }
        
        return "";
  }
}
