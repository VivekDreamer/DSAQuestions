//https://www.geeksforgeeks.org/problems/smallest-window-in-a-string-containing-all-the-characters-of-another-string-1587115621/1
class POTD_SmallestWindowInAStringContainingAllTheCharactersOfAnotherString
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p){
        int n = s.length();
        Map<Character,Integer> map = new HashMap<>();
        for(char ch : p.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        int requiredCount = p.length();
        int i = 0, j = 0;
        int minStart = 0;
        int minWindow = Integer.MAX_VALUE;
        
        while(j < n){
            char ch_j = s.charAt(j);
            if(map.containsKey(ch_j) && map.get(ch_j) > 0){
                requiredCount--;
            }
            
            map.put(ch_j, map.getOrDefault(ch_j,0)-1);
            
            while(requiredCount == 0){
                if(minWindow > j-i+1){
                    minWindow = j-i+1;
                    minStart = i;
                }
                
                char ch_i = s.charAt(i);
                map.put(ch_i,map.getOrDefault(ch_i,0)+1);
                if(map.get(ch_i) > 0){
                    requiredCount++;
                }
                
                i++;
            }
            j++;
        }
        return minWindow == Integer.MAX_VALUE ? "-1" : s.substring(minStart, minStart + minWindow);
    }
}
