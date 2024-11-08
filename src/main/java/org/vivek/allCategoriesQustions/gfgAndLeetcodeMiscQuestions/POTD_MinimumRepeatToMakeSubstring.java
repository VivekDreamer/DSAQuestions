// https://www.geeksforgeeks.org/problems/minimum-times-a-has-to-be-repeated-such-that-b-is-a-substring-of-it--170645/1
public class POTD_MinimumRepeatToMakeSubstring {
    static int minRepeats(String s1, String s2) {
        // TLE
        /*
        String rep = s1;
        int count = 1;
        while(s1.length() < s2.length()){
            s1+=rep;
            count++;
        }
        if(s1.contains(s2)) return count;
        s1+=rep;
        count++;
        if(s1.contains(s2)) return count;
        return -1;
        */
        for(int i = 0; i < s2.length(); i++){
            if(!s1.contains(String.valueOf(s2.charAt(i)))) return -1;
        }   
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while(sb.length() < s2.length()){
            count++;
            sb.append(s1);
        }
        if(sb.toString().contains(s2)){
            return count;
        }
        sb.append(s1);
        count++;
        if(sb.toString().contains(s2)){
            return count;
        }
        return -1;
    }
}
