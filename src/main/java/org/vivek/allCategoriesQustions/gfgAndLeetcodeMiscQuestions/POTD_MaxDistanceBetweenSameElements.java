https://www.geeksforgeeks.org/problems/max-distance-between-same-elements/1
public class POTD_MaxDistanceBetweenSameElements{
  public int maxDistance(int[] arr) {
      int max=Integer.MIN_VALUE;
      HashMap<Integer,Integer>mp=new HashMap<>();
      for(int i=0;i<arr.length;i++){
          if(mp.containsKey(arr[i])){
              max=Math.max(max,Math.abs(i-mp.get(arr[i])));
          }
          else{
              mp.put(arr[i],i);
          }
      }
      return max;
  }
}
