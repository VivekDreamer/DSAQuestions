// https://www.geeksforgeeks.org/problems/sum-of-prime4751/1
import java.util.ArrayList;
class POTD_PrimePairWithTargetSum {
    public static ArrayList<Integer> getPrimes(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int a = 2; a <= n / 2; ++a) {
            int b = n - a;
            if (isPrime(a) && isPrime(b)) {
                ans.add(a);
                ans.add(b);
                return ans;
            }
        }
        ans.add(-1);
        ans.add(-1);
        return ans;
    }
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }
}
