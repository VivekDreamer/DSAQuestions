// https://www.geeksforgeeks.org/problems/modular-exponentiation-for-large-numbers5537/1
class POTD_ModularExponentiationForLargeNumbers{
    public long PowMod(long x, long n, long m){
        if(n == 0) return 1;
        if(n % 2 == 0) return PowMod((x % m * x % m) % m, n/2, m);
        else return (x % m * PowMod(x,n-1,m)) % m;
    }
}
