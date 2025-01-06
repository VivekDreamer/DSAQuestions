// https://www.geeksforgeeks.org/problems/pair-in-array-whose-sum-is-closest-to-x1124/1
public class POTD_SumPairClosestToTarget {
    public List<Integer> sumClosest(int[] arr, int target) {
        List<Integer>li=new ArrayList<>();
        Arrays.sort(arr);
        int i=0;
        int j=arr.length-1;
        int min=Integer.MAX_VALUE;
        while(i<j){
            int sum=arr[i]+arr[j];
            int diff=Math.abs(target-sum);
            if(diff<min){ 
                min=diff;
                li=Arrays.asList(arr[i],arr[j]);
            }
            if(sum>target){
                j--;
            }else if(sum<target){
                i++;
            }else {
                return Arrays.asList(arr[i],arr[j]);
            }
        }
        return li;
    }
}
