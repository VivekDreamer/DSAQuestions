// https://www.geeksforgeeks.org/problems/split-an-array-into-two-equal-sum-subarrays/1
class POTD_SplitAnArrayIntoTwoEqualSumSubarrays {
    public boolean canSplit(int arr[]) {
        // code here
        int leftSum = 0;
        int rightSum = 0;
        for(int val : arr){
            rightSum += val;
        }
        
        for(int val : arr){
            leftSum += val;
            rightSum -= val;
            if(leftSum == rightSum){
                return true;
            }
        }
        return false;
    }
}
