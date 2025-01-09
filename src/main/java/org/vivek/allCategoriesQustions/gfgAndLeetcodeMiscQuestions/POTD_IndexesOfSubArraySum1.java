// https://www.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1
public class POTD_IndexesOfSubArraySum1 {
    static ArrayList<Integer> subarraySum(int[] arr, int s) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        int sum = 0;
        while(j < n){
            sum+=arr[j];
            while(i <= j && sum > s){
                sum-=arr[i];
                i++;
            }
            if(sum == s && i <= j){
                res.add(i+1);
                res.add(j+1);
                return res;
            }
            j++;
        }
        res.add(-1);
        return res;
    }
}
