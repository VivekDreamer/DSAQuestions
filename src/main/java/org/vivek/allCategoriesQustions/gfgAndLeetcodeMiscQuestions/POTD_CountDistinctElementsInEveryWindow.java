// https://www.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/1
class POTD_CountDistinctElementsInEveryWindow {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int j = k - 1;
        for (int i = 0; i <= arr.length - k; i++) {
            set.clear();
            int start = i;
            while (start <= j) {
                set.add(arr[start]);
                start++;
            }
            ans.add(set.size());
            j++;
        }
        return ans;
    }
}
