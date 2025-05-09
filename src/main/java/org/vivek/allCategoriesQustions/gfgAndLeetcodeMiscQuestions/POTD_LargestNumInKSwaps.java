public class POTD_LargestNumInKSwaps {
    // Function to find the largest number after k swaps.
    public String findMaximumNum(String s, int k) {
        String[] ans = new String[1];
        ans[0] = s;
        findMaxUtil(s.toCharArray(),k,0,ans);
        return ans[0];
    }
    public void findMaxUtil(char[] str, int k, int start, String[] ans){
        if(start == str.length-1 || k == 0) return;
        //finding max digit from start to end;
        int maxs = str[start];
        for(int i = start + 1; i < str.length; i++){
            if(str[i] > maxs) maxs = str[i];
        }
        for(int i = start + 1; i < str.length; i++){
            if(str[i] == maxs && str[start] < str[i]){
                swap(str,start,i);
                String current = new String(str);
                if(current.compareTo(ans[0])>0) ans[0] = current;
                findMaxUtil(str,k-1,start+1,ans);
                swap(str,start,i);
            }
        }
        //horizontal drifting
        findMaxUtil(str,k,start+1,ans);
    }
    public void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
