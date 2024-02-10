package org.vivek.allCategoriesQustions.binarySearch;

import java.util.PriorityQueue;

// https://takeuforward.org/arrays/minimise-maximum-distance-between-gas-stations/
public class MinimizeMaximumDistanceBetweenGasStations {

    //brute force - TLE
    // We are given n gas stations. Between them, there are n-1 sections where we may insert the new stations to reduce the distance. 
    // So, we will create an array of size n-1 and each of its indexes will represent the respective sections between the given gas stations. 

    //for understanding - dryy run below test case
    // arr = {1,13,17,23} , k = 5
    public static double minimizeMaxDistance(int[] arr, int k){
        int n = arr.length;
        int[] howMany = new int[n-1];
        //pick and place k gas stations
        for(int gasStations = 1; gasStations <= k; gasStations++){
            //find the maximum section and insert the gas station
            double maxSection = -1;
            int maxInd = -1;
            for(int i = 0; i < n-1; i++){
                double diff = arr[i+1] - arr[i];
                double sectionLength = diff / (double)(howMany[i] + 1);
                if(sectionLength > maxSection){
                    maxSection = sectionLength;
                    maxInd = i;
                }
            }
            //insert the current gas station
            howMany[maxInd]++;
        }

        //find the maxDistance
        double maxAns = -1;
        for(int i = 0; i < n-1; i++){
            double diff = arr[i+1] - arr[i];
            double sectionLength = diff / (double)(howMany[i]+1);
            maxAns = Math.max(maxAns, sectionLength);
        }
        return maxAns;
    }

    //better approach using max heap 
    public static double minimizeMaxDistanceBetter(int[] arr, int k){
        int n = arr.length;
        int[] howMany = new int[n-1];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Double.compare(b.first, a.first));
        //insert the first n-1 elements into the pq with respective distance value
        for(int i = 0; i < n-1; i++){
            pq.add(new Pair(arr[i+1]-arr[i], i));
        }

        //pick and place k gas stations
        for(int gasStations = 1; gasStations <= k; gasStations++){
            //find the maximum section and insert the gas station
            Pair tp = pq.poll();
            int sectionIdx = tp.second;
            //insert the gas station 
            howMany[sectionIdx]++;
            double initialSectionDiff = arr[sectionIdx+1] - arr[sectionIdx];
            double newSectionDiff = initialSectionDiff / (double)(howMany[sectionIdx]+1);
            pq.add(new Pair(newSectionDiff, sectionIdx));
        }
        return pq.peek().first;
    }

    public static double minimizeMaxDistanceOptimal(int[] arr, int k){
        int n = arr.length;
        double low = 0;
        double high = 0;
        for(int i = 0; i < n-1; i++){
            high = Math.max(high, (double)(arr[i+1]-arr[i]));
        }

        //apply binary search
        double diff = 1e-6;
        while(high - low > diff){
            double mid = (low + high)/2.0;
            int count = numberOfGasStationReq(mid,arr);
            if(count > k){
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;

    }

    private static int numberOfGasStationReq(double dist, int[] arr) {
        int n = arr.length;
        int count = 0;
        for(int i = 1; i < n; i++){
            int numberInBetween = (int)((arr[i] - arr[i-1]) / dist);
            if((arr[i] - arr[i-1]) == (dist * numberInBetween)){
                numberInBetween--;
            }
            count += numberInBetween;
        }
        return count;
    }
}
class Pair{
    double first; 
    int second;
    Pair(double _first, int _second){
        this.first = _first;
        this.second = _second;
    }
}
