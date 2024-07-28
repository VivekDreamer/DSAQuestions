// https://www.geeksforgeeks.org/problems/remove-duplicates3034/1
class POTD_RemoveDuplicates {
    String removeDups(String str) {
        String ans = new String();
        for(char c : str.toCharArray()) {
            if(ans.indexOf(c) == -1) {
                ans+=c;
            }
        }
        return ans;
    }
}
