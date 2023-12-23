package org.vivek.allCategoriesQustions.arrays;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/path-crossing/
public class Leetcode_PathCrossing {
    public boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        int x = 0;
        int y = 0;
        String key = x + "_" + y;
        set.add(key);
        for(int i = 0; i < path.length(); i++){
            if(path.charAt(i) == 'N') y++;
            else if(path.charAt(i) == 'S') y--;
            else if(path.charAt(i) == 'E') x++;
            else if(path.charAt(i) == 'W') x--;
            
            key = x + "_" + y;
            if(set.contains(key)) return true;
            set.add(key);
        }
        return false;
    }
}
