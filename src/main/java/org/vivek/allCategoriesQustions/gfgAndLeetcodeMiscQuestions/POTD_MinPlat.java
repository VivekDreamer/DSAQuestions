class POTD_MinPlat {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
        int n = arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int platforms = 1, result = 1;
        int i = 1, j = 0;
        while(i < n && j < n){
            if(arr[i] <= dep[j]){
                platforms++;
                i++;
            }else if(arr[i] > dep[j]){
                platforms--;
                j++;
            }
            result = Math.max(result, platforms);
        }
        return result;
    }
}
