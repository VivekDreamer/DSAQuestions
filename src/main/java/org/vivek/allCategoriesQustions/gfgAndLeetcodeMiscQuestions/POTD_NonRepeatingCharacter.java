// https://www.geeksforgeeks.org/problems/non-repeating-character-1587115620/1
public class POTD_NonRepeatingCharacter {
    // Function to find the first non-repeating character in a string.
    static char nonRepeatingChar(String s) {
        int h[] = new int[26];
        Arrays.fill(h, 0);
        //using hash table to store count of each character.
        for(int i = 0;i<s.length();i++){
            h[s.charAt(i)-'a']++;
        }
        for(int i = 0;i<s.length();i++)
        {
            //if count of current character is 1, we return it. 
            if(h[s.charAt(i)-'a'] == 1){
                return(s.charAt(i));
            }
        }
        //if there is no non-repeating character then we return '$'.
        return '$';
    }
}
