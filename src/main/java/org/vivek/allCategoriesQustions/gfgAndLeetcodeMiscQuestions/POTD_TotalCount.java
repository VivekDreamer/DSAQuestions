// https://www.geeksforgeeks.org/problems/total-count2415/1
class POTD_TotalCount {
    int totalCount(int k, int[] arr) {
        int count = 0;
        int n = arr.length;
        
        for(int i =0;i<n;i++)
        {
            int div = arr[i]/k;
            int rem = arr[i]%k;
            if(rem!=0)
            {
                div++;
            }
            
            count +=div;
        }
        return count;
    }
}
