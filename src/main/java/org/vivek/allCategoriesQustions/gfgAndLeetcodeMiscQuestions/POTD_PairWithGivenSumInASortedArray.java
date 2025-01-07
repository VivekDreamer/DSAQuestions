class POTD_PairWithGivenSumInASortedArray {
    int countPairs(int arr[], int target) {
        int count = 0;
        int left = 0;
        int right = arr.length-1;
        while(left < right){
            int sum = arr[left] + arr[right];
            if(sum == target){
                count++;
                int l = left+1;
                while(l < right && arr[l] == arr[left]){
                    count++;
                    l++;
                }
                int r = right-1;
                while(left < r && arr[r] == arr[right]){
                    count++;
                    r--;
                }
                left++;
                right--;
            }
            else if(sum < target){
                left++;
            }
            else{
                right--;
            }
        }
        return count;
    }
}
