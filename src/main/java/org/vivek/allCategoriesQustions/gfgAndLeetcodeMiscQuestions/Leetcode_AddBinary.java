// https://leetcode.com/problems/add-binary/
public class Leetcode_AddBinary {
    public String addBinary(String a, String b) {
        int length1 = a.length();
        int length2 = b.length();
        int carry = 0;
        String result = "";
        int max_length = Math.max(length1,length2);
        for(int i = 0; i < max_length; i++){
            int p = i < length1 ? a.charAt(length1 - 1 - i) - '0': 0;
            int q = i < length2 ? b.charAt(length2 - 1 - i) - '0' : 0;
            int temp = p + q + carry;
            carry = temp/2;
            result = temp % 2 + result;
        }
        return (carry==0)?result:"1"+result;
    }
}
