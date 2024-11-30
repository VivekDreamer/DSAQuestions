// https://www.geeksforgeeks.org/problems/anagram-1587115620/1
public class POTD_Anagram {
    // Function is to check whether two strings are anagram of each other or not.
    public static boolean areAnagrams(String s1, String s2) {
        if(s1.length()!=s2.length()) return false;
        int alpha[] = new int[26];
        for(int i = 0; i<s1.length(); i++){
            alpha[s1.charAt(i)-(int)'a']++;
        }
        for(int i = 0; i<s2.length(); i++){
            alpha[s2.charAt(i)-(int)'a']--;
        }
        for(int i = 0; i<alpha.length; i++){
            if(alpha[i]!=0) return false;
        }
        return true;
    }
}
