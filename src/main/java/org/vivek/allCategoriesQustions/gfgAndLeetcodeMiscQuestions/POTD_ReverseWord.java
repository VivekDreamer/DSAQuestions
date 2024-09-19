// https://www.geeksforgeeks.org/problems/reverse-words-in-a-given-string5459/1
class POTD_ReverseWord 
{
    //Function to reverse words in a given string.
    String reverseWords(String str)
    {
        String result="";
        int i = 0;
        int n = str.length();
        while(i < n){
            while(i < n && str.charAt(i)=='.') i++;
            if(i >= n)break;
            int j = i+1;
            while(j < n && str.charAt(j) != '.')j++;
            String sub = str.substring(i, j);
            if(result.length() == 0) result = sub;
            else result = sub+"."+result;
            i = j+1;
        }
        return result;
    }
}
