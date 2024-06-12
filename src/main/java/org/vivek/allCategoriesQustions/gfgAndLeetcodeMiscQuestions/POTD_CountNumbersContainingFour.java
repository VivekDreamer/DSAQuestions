// https://www.geeksforgeeks.org/problems/count-numbers-containing-43022/1
class POTD_CountNumbersContainingFour {
    public static int countNumberswith4(int n) {
        int ans = 0;
        int temp;
        for(int i = 1; i <= n; i++){
            temp = i;
            while(temp != 0){
                if(temp%10 == 4){
                    ans+=1;
                    break;
                }
                temp/=10;
            }
        }
        return ans;
    }
}
