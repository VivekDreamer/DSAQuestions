// https://www.geeksforgeeks.org/problems/nearest-multiple-of-102437/1
public class POTD_NearestMultipleOf10 {

    String roundToNearest(String str) {
        StringBuilder sb = new StringBuilder(str);
        int n = str.length();
        
        if (sb.charAt(n - 1) <= '5') {
            sb.setCharAt(n - 1, '0');
        } else {
            sb.setCharAt(n - 1, '0');
            for (int i = n - 2; i >= 0; i--) {
                int a = sb.charAt(i) - '0';
                a += 1;
                if (a != 10) {
                    sb.setCharAt(i, (char) (a + '0'));
                    return sb.toString();
                }
                sb.setCharAt(i, '0');
            }
            sb.insert(0, '1');
        }
        return sb.toString();
    }
}
