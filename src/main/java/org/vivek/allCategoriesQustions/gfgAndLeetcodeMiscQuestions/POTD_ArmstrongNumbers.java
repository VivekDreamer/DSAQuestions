// https://www.geeksforgeeks.org/problems/armstrong-numbers2727/1
class POTD_ArmstrongNumbers {
    static String armstrongNumber(int n) {
        /*int ans = 0;
        int temp = n;
        while(temp > 0){
            int num = temp % 10;
            ans += (num * num * num);
            temp /= 10;
        }
        return ans == n ? "true" : "false" ;*/
        
        return ((n == 153) || (n == 370) || (n == 371) || (n == 407)) ? "true" : "false";
    }
}
