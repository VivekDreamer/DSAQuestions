// https://www.geeksforgeeks.org/problems/longest-prefix-suffix2527/1
class POTD_LongestPrefixSuffix {
    int lps(String str) {
        int n=str.length();
        int p=0,s=1,cnt=0,pos=0;
        while(p<n&&s<n){
            if(str.charAt(p)==str.charAt(s)){
                p++;
                s++;
                cnt++;
            }
            else{
                pos++;
                s=pos;
                cnt=0;
                p=0;
            }
        }
        return cnt;
    }
}
