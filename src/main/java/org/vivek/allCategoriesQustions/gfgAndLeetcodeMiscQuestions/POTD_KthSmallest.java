// https://www.geeksforgeeks.org/problems/kth-smallest-element5635/1
class POTD_KthSmallest {
    public static int kthSmallest(int[] arr, int k) {
        // Your code here
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : arr){
            maxHeap.add(num);
            if(maxHeap.size() > k) maxHeap.remove();
        }
        return maxHeap.peek();
    }
}
