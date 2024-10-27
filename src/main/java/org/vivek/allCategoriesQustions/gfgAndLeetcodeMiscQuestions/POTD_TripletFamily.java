// https://www.geeksforgeeks.org/problems/triplet-family/1
public class POTD_TripletFamily{
    public boolean findTriplet(int[] arr) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0; i<arr.length; i++) {
            hs.add(arr[i]);
        }
        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(hs.contains(arr[i]+arr[j])) return true;
            }
        }
        return false;
    }
}
