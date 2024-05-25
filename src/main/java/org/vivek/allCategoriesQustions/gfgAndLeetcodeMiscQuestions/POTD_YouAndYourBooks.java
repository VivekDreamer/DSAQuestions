// https://www.geeksforgeeks.org/problems/you-and-your-books/1
class POTD_YouAndYourBooks {
    long max_Books(int arr[], int n, int k) {
        long sum = 0;
        long ans = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] <= k) sum+=arr[i];
            else{
                ans = Math.max(ans,sum);
                sum = 0;
            }
        }
        ans = Math.max(ans,sum);
        return ans;
    }
}
