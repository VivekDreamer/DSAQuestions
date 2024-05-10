// https://www.geeksforgeeks.org/problems/combination-sum-ii-1664263832/1
class POTD_CombinationSumII {
    public List<List<Integer>> CombinationSum2(int arr[], int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        findCombinations(0, arr, k, ans, new ArrayList<>());
        return ans;
    }
    public void findCombinations(int idx, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds){
        if(target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = idx; i < arr.length; i++){
            if(i > idx && arr[i] == arr[i-1]) continue;
            if(arr[i] > target) break;
            ds.add(arr[i]);
            findCombinations(i+1,arr,target-arr[i],ans,ds);
            ds.remove(ds.size()-1);
        }
    }
}
