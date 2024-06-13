// https://www.geeksforgeeks.org/problems/padovan-sequence2855/1
class POTD_PadovanSequence{
    int MOD = (int)(1e9+7);
    public int padovanSequence(int n){
        int one = 1, two = 1, three = 1;
        for(int i = 3; i <= n; i++){
            int temp = (one+two)%MOD;
            one   =   two % MOD;
            two   =   three % MOD;
            three =   temp % MOD;
        }
        return three;
    }
}
