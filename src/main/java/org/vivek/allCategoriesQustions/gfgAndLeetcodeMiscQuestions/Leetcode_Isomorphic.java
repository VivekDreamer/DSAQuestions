class Leetcode_Isomorphic {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())return false;
        Map<Character, Character> map1 = new HashMap<>();
	    Map<Character, Boolean>   map2 = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char char1 = s.charAt(i);
            char char2 = t.charAt(i);
            if(map1.containsKey(char1)){
                if(map1.get(char1)!=char2)return false;
            }
            else{
                if(map2.containsKey(char2)==true)return false;
                map1.put(char1,char2);
                map2.put(char2,true);
            }
        }
        return true;
    }
}
