// https://www.geeksforgeeks.org/problems/subarray-range-with-given-sum0128/1
class POTD_SubarrayRangeWithGivenSum {
    // Function to count the number of subarrays which adds to the given sum.
    static int subArraySum(int arr[], int tar) {
        int cursum=0;
        int count=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,1);
        for(int i=0;i<arr.length;i++){
            cursum+=arr[i];
            if(map.containsKey(cursum-tar)){
                count+=map.get(cursum-tar);
               
            }
            map.put(cursum,map.getOrDefault(cursum,0)+1);
        }
        return count;
    }
}
