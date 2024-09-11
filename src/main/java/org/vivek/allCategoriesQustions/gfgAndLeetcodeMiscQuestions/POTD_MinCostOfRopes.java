// https://www.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1
class POTD_MinCostOfRopes {
    // Function to return the minimum cost of connecting the ropes.
    public long minCost(long[] arr) {
        long sum=0L;
        PriorityQueue<Long>pq=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        while(!pq.isEmpty()){
            long first=pq.poll();
            if(!pq.isEmpty()){
              long second=pq.poll();
              sum+=first+second;
              pq.add(first+second);
            }
            else{
                return sum;
            }
        }
        return sum;
    }
}
