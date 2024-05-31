// https://www.geeksforgeeks.org/problems/swap-two-nibbles-in-a-byte0446/1
class POTD_SwapTwoNibblesInByte {
    static int swapNibbles(int n) {
        return (n>>4)|((n&15)<<4);
    }
}
