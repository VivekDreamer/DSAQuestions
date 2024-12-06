// https://www.geeksforgeeks.org/problems/find-h-index--165609/1
public class POTD_FindHIndex {
    // Function to find hIndex
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            // Calculate the number of papers with citations >= citations[i]
            int H = n - i;
            if (citations[i] >= H) {
               return H;
            }
        }
        
        return 0;
    }
}
