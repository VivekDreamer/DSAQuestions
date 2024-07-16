// https://www.geeksforgeeks.org/problems/remaining-string3515/1
class POTD_RemainingString {
    public String printString(String s, char ch, int count) {
        // code here
        int c=0;
        StringBuilder res=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==ch){
                c++;
                if(c==count){
                     for(int j=i+1;j<s.length();j++){
                        res.append(s.charAt(j));
                   }
                      break;
                }
            }
        }
         
        return res.toString();
    }
}
