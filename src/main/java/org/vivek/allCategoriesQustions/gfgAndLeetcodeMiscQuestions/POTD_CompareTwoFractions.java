// https://www.geeksforgeeks.org/problems/compare-two-fractions4438/1
class POTD_CompareTwoFractions {
    String compareFrac(String str) {
        String[] temp = str.split("[/,]");
        int a = Integer.parseInt(temp[0]);
        int b = Integer.parseInt(temp[1]);
        int c = Integer.parseInt(temp[2].trim());
        int d = Integer.parseInt(temp[3]);
        int ad = a * d;
        int cb = c * b;
        String ans = null
        if (ad > cb) {
            ans = a + "/" + b;
        } 
        else if (cb > ad) {
            ans = c + "/" + d;
        } 
        else if (ad == cb) {
            ans = "equal";
        }
        return ans;
    }
}
