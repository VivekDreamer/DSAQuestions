// https://www.geeksforgeeks.org/problems/sorted-subsequence-of-size-3/1
class POTD_SortedSubsequenceOfSize3 {
    // Function to find three numbers such that arr[smaller[i]] < arr[i] <
    // arr[greater[i]]
    public List<Integer> find3Numbers(int[] arr) {
        // code here
        List<Integer> ans = new ArrayList<>();
        int n =arr.length;
        int[] smaller = new int[n];
        int[] greater = new int[n];
        smaller[0] =-1;
        greater[n-1] =-1;

        // build our smaller array
        int minIndex =0;
        for(int i=1;i<n;i++){
            if(arr[i]<= arr[minIndex]){
                minIndex =i;
                smaller[i] =-1;
            }else{
                smaller[i] = minIndex;
            }
        }

        //build our greater array
        int maxIndex =n-1;
        for(int i=n-2;i>=0;i--){
            if(arr[i] >= arr[maxIndex]){
                maxIndex =i;
                greater[i] =-1;
            }else{
                greater[i] = maxIndex;
            }
        }

        for(int i=0;i<n;i++){
            if(smaller[i] !=-1 && greater[i] !=-1){
                ans.add(arr[smaller[i]]);
                ans.add(arr[i]);
                ans.add(arr[greater[i]]);
                return ans;
            }
        }
        return ans;
    }
}
