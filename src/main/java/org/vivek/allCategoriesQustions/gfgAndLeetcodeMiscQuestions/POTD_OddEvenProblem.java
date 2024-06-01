// https://www.geeksforgeeks.org/problems/help-nobita0532/1
class POTD_OddEvenProblem {
    // public static String oddEven(String s) {
    //     Hashtable<Character, Integer> freq = new Hashtable<>();
    //     int x = 0, y = 0;
    //     for (int i = 0; i < s.length(); i++){
    //         freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0)+1);
    //     }
    //     for (char c: freq.keySet()){
    //         if ((c + 1 - 'a')%2 == 1 && freq.get(c)%2 == 1)
    //             x += 1;
    //         else if ((c + 1 - 'a')%2 == 0 && freq.get(c)%2 == 0)
    //             y += 1;
    //     }
    //     return ((x+y)%2 == 1) ? "ODD" : "EVEN";
    // }

    
    public static String oddEven(String s) {
        int []alpha=new int[26];
        for(int i=0;i<s.length();i++) alpha[s.charAt(i)-'a']++;
        int count=0;
        for(int i=0;i<26;i++){
            if(alpha[i]==0) continue;
            if((i+1)%2==0 && alpha[i]%2==0) count++;
            if((i+1)%2!=0 && alpha[i]%2!=0) count++;
        }
        return count%2==0?"EVEN":"ODD";
    }
}
