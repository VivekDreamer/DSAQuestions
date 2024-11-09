// https://www.geeksforgeeks.org/problems/minimum-sum4058/1
public class POTD_MinimumSum {
    String minSum(int[] arr) {
        Arrays.sort(arr);
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        boolean flag = true;
        // Split digits alternately between sb1 and sb2
        for (int num : arr) {
            if (flag) {
                sb1.append(num);
            } else {
                sb2.append(num);
            }
            flag = !flag;
        }
        
        int i = sb1.length() - 1;
        int j = sb2.length() - 1;
        int carry = 0;
        StringBuilder ans = new StringBuilder();
        // Add the two strings sb1 and sb2 from right to left
        while (i >= 0 || j >= 0 || carry == 1) {
            int val1 = i >= 0 ? sb1.charAt(i) - '0' : 0;
            int val2 = j >= 0 ? sb2.charAt(j) - '0' : 0;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            ans.append(sum % 10);
            i--;
            j--;
        }
        // Reverse the result since it was built in reverse order
        ans.reverse();
        // Remove leading zeros
        int z = 0;
        while (z < ans.length() && ans.charAt(z) == '0') {
            z++;
        }
        return ans.substring(z);
    }
}
