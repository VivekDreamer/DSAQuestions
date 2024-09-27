// https://www.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1
class POTD_KSizedSubarrayMaximum {
    // Function to find maximum of each subarray of size k.
    public ArrayList<Integer> max_of_subarrays(int k, int arr[]) {
        // Your code here
        int n = arr.length;
        int i = 0, j = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();
        while(j < n){
            //calculation for j
            while(!queue.isEmpty() && queue.peekLast() < arr[j]){
                queue.pollLast();
            }
            queue.offerLast(arr[j]);
            if(j - i + 1 < k) j++;
            else{
                ans.add(queue.peekFirst());
                //removing calculations for i
                if(queue.peekFirst() == arr[i]){
                    queue.pollFirst();
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}
