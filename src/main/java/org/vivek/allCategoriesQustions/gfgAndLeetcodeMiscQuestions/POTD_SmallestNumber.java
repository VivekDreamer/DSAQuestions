// https://www.geeksforgeeks.org/problems/smallest-number5829/1
class POTD_SmallestNumber {
    public String smallestNumber(int s, int d) {
        int start=(int)Math.pow(10,d-1);
        int end=(start*10)-1;
        int ans=0;
        while(start<=end){
            int num=start;
            int check=0;
            while(num!=0){
                int rem=num%10;
                check+=rem;
                num=num/10;
            }
            if(check==s){
                ans=start;
                break;
            }
            start++;
        }
        if(ans==0){
            return String.valueOf(-1);
        }
        return String.valueOf(ans);
    }
}
