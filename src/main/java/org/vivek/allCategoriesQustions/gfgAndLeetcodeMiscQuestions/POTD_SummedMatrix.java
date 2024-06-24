// https://www.geeksforgeeks.org/problems/summed-matrix5834/1
class POTD_SummedMatrix {
    static long sumMatrix(long n, long q) {
        if(q > 2*n) return 0;
        else if(q <= n) return (q-1);
        else return (2*n-q+1);
    }
}
