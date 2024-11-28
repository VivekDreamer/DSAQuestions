// https://www.geeksforgeeks.org/problems/implement-atoi/1
public class POTD_ImplementAtoi {
    public int myAtoi(String s) {
        int flag=0,sign=0;
        long no=0;
        long check=(long)2147483648L;
        for(char c:s.toCharArray()){
            
            if(flag==0 && (c==' ' || c=='0')){ continue;}
            if(flag==0 && c=='+') sign=1;
            else if(flag==0 && c=='-') sign=-1;
            else if(c-'0'<=9 && c-'0'>=0) {
                flag=1;
                no=no*10+(int)(c-'0');}
            else  break;
            
        }
        if((sign==1 || sign==0) && no>=check ) return (int)check-1;
        else if(sign==-1 && no>check) return (int)check*-1;
        if(sign==-1) return (int)no*-1;
        return (int)no;
    }
}
