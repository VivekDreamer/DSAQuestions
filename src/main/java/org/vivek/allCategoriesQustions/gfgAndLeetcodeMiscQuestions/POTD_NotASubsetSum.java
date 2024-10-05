// https://www.geeksforgeeks.org/problems/smallest-number-subset1220/1
public class POTD_NotASubsetSum {
    public long findSmallest(int[] arr) {
        long  sum=0;
        for(int i=0;i<arr.length;i++){
            if(sum+1<arr[i])return sum+1;
            sum+=arr[i];
        }
        return sum+1;
    }
}
