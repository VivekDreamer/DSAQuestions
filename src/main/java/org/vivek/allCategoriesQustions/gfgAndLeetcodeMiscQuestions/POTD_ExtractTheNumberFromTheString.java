// https://www.geeksforgeeks.org/problems/extract-the-number-from-the-string3428/1
class POTD_ExtractTheNumberFromTheString {
    long ExtractNumber(String sentence) {
        long ans = -1;
        long curr = -1;
        int i = 0;
        while(i < sentence.length()){
            if(!Character.isDigit(sentence.charAt(i))) i++;
            else{
                curr = 0;
                while(Character.isDigit(sentence.charAt(i))){
                    if(sentence.charAt(i) == '9'){
                        curr = -1;
                        while(i < sentence.length() && sentence.charAt(i) != ' ') i++;
                        break;
                    }
                    curr = curr * 10 + sentence.charAt(i) - '0';
                    i++;
                }
                if(ans < curr) ans = curr;
            }
        }
        return ans == 0 ? -1 : ans;
    }
}
