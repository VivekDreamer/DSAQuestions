// https://www.geeksforgeeks.org/problems/roof-top-1587115621/1
class POTD_RoofTop {
    // Function to find maximum number of consecutive steps
    // to gain an increase in altitude with each step.
    public int maxStep(int arr[]) {
        int n = arr.length;
        int count = 0;
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i<n-1; i++){
            if(arr[i+1] > arr[i]){
                count++;
            }
            else{
                maxi = Math.max(maxi, count);
                count = 0;
            }
        }
        maxi = Math.max(maxi, count);
        return maxi;
    }
}
