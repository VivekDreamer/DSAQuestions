// https://www.geeksforgeeks.org/problems/nth-natural-number/1
class POTD_NthNaturalNumber {
    long findNth(long n) {
        long result = 0;
        long p = 1;
        while (n > 0) {
            result += (p * (n % 9));
            n= n / 9;
            p = p * 10;
        }
        return result;
    }
}
