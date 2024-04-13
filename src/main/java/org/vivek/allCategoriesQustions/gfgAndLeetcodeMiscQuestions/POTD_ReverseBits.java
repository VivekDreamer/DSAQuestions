// https://www.geeksforgeeks.org/problems/reverse-bits3556/1
class POTD_ReverseBits {
    static Long reversedBits(Long x) {
        long num = 0;
        for(int i = 0; i<32; i++){
            long bit = (x & (1 << i)) > 0 ? 1: 0;
            num = num + (bit << (31-i));
        }
        return num;
    }
};
