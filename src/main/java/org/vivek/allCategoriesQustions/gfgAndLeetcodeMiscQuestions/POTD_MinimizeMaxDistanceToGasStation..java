// https://www.geeksforgeeks.org/problems/minimize-max-distance-to-gas-station/1
class POTD_MinimizeMaxDistanceToGasStation {
    //1 , 13, 17, 23 station = 5
    /*
    public static double findSmallestMaxDist(int stations[], int k) {
        int[] sectionLength = new int[stations.length-1];
        for(int gasStation = 1; gasStation <= k; gasStation++){
            //finding maximum distance between two consecutive and insert gas station
            double maxDistance = -1;
            int maxIdx = -1;
            for(int i = 0; i < stations.length-1; i++){
                double diff = stations[i+1] - stations[i];
                double eachPartLength = diff / (double)(sectionLength[i]+1);
                if(eachPartLength > maxDistance){
                    maxDistance = eachPartLength;
                    maxIdx = i;
                }
            }
            //insert current gasStation
            sectionLength[maxIdx]++;
        }
        
        //finding maximum distance
        double res = -1;
        for(int i = 0; i < stations.length-1; i++){
            double diff = stations[i+1]-stations[i];
            double eachPartLength = diff / (double)(sectionLength[i]+1);
            res = Math.max(res,eachPartLength);
        }
        
        return res;
    }
    */
    
    // TC : nlogn + klogn
    // SC : O(n-1)
    /*
    public static double findSmallestMaxDist(int stations[], int k) {
        int n = stations.length;
        int[] sectionLength = new int[n-1];
        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b) ->Double.compare(b.diff,a.diff)); //max-heap
        for(int i = 0; i < n-1; i++){
            queue.add(new Pair(stations[i+1]-stations[i], i));
        }
        for(int gasStation = 1; gasStation <= k; gasStation++){
            Pair pair = queue.poll();
            int idx = pair.idx;
            sectionLength[idx]++;
            double initialDiff = stations[idx+1] - stations[idx];
            double newSectionLength = initialDiff / (double)(sectionLength[idx]+1);
            queue.add(new Pair(newSectionLength, idx));
        }
        return queue.peek().diff;
    }
    
    public static class Pair{
        double diff;
        int idx;
        Pair(double _diff, int _idx){
            this.diff = _diff;
            this.idx = _idx;
        }
    }
    */
    
    // O(n*log(Len)) + O(n), n = size of the given array, Len = length of the answer space.
    public static double findSmallestMaxDist(int stations[], int k) {
        int n = stations.length;
        double low = 0;
        double high = 0;
        //finding maximum distance
        for(int i = 0; i < n-1; i++){
            high = Math.max(high, (double)(stations[i+1]-stations[i]));
        }
        //binary search
        double diff = 1e-6;
        while(high - low > diff){
            double mid = low + (high - low)/2.0;
            int cnt = numberOfGasStationsRequired(mid, stations);
            if(cnt > k) low = mid;
            else high = mid; 
        }
        return high;
    }
    public static int numberOfGasStationsRequired(double distance, int[] arr){
        int n = arr.length;
        int cnt = 0;
        for(int i = 1; i < n; i++){
            int numberInBetween = (int)((arr[i] - arr[i-1])/distance);
            if((arr[i] - arr[i-1]) == (distance * numberInBetween)) numberInBetween--;
            cnt+=numberInBetween;
        }
        return cnt;
    }
    
}
