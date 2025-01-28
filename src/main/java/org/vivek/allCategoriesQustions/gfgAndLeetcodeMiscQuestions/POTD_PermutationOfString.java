// https://www.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1
public class POTD_PermutationOfString {
    public ArrayList<String> findPermutation(String str) {
        List<String> list = new ArrayList<>();
        Set<String> set = new TreeSet<>();
        boolean[] freq = new boolean[str.length()];
        recurPermute(str,set,freq,new StringBuilder());
        return new ArrayList(set);
    }
    public void recurPermute(String str, Set<String> ans, boolean[] freq, StringBuilder sb){
        if(str.length() == sb.length()){
            ans.add(new String(sb));
            return;
        }
        for(int i = 0; i < str.length(); i++){
            if(!freq[i]){
                freq[i] = true;
                sb.append(str.charAt(i));
                recurPermute(str,ans,freq,sb);
                sb.deleteCharAt(sb.length()-1);
                freq[i] = false;
            }
        }
    }
}
