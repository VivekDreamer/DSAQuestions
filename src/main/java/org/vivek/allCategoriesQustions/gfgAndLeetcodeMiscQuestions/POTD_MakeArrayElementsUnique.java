// https://www.geeksforgeeks.org/problems/make-array-elements-unique--170645/1
public class POTD_MakeArrayElementsUnique {
    public int minIncrements(int[] arr) {
        Arrays.sort(arr);
        int ans = 0;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] <= arr[i-1]) {
                ans += (arr[i-1] - arr[i] + 1);
                arr[i] = arr[i-1] + 1;
            }
        }
        return ans;
    }
}
