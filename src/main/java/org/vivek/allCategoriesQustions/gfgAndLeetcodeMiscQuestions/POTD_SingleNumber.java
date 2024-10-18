// https://www.geeksforgeeks.org/problem-of-the-day
class POTD_SingleNumber {
    int getSingle(int arr[]) {
        int ans =0;
        for(int i=0;i<arr.length;i++)
        {
            ans = ans ^ arr[i];
        }
        return ans;
    }
}
