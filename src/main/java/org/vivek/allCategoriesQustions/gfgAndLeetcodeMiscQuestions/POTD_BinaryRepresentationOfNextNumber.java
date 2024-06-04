// https://www.geeksforgeeks.org/problems/binary-representation-of-next-number3648/1
class POTD_BinaryRepresentationOfNextNumber {
    String binaryNextNumber(String str) {
        StringBuilder sb = new StringBuilder(str);
        boolean flag = false;
        for(int i = sb.length()-1; i >= 0; i--){
            if(sb.charAt(i) == '0'){
                sb.setCharAt(i,'1');
                flag = true;
                break;
            }else{
                sb.setCharAt(i,'0');
            }
        }
        if(!flag) sb.insert(0,'1');
        int startIdx = 0;
        while(startIdx < sb.length() && sb.charAt(startIdx) == '0') startIdx++;
        return sb.substring(startIdx);
    }
}
