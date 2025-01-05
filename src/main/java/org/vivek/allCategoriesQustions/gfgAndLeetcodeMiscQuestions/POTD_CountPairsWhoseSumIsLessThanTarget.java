// https://www.geeksforgeeks.org/problems/count-pairs-whose-sum-is-less-than-target/1
class POTD_CountPairsWhoseSumIsLessThanTarget {
    int countPairs(int arr[], int target) {
        Arrays.sort(arr);
        int n = arr.length;
        int i = 0, j = n - 1;
        int count = 0;
        while(i < j) {
            int sum = arr[i] + arr[j];
            if(sum < target) {
                count += (j - i);
                i++;
            } else {
                j--;
            }
        }
        return count;
    }
}
