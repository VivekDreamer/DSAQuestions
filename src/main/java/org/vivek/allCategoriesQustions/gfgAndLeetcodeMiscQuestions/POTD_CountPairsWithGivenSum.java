// https://www.geeksforgeeks.org/problems/count-pairs-with-given-sum--150253/1
class POTD_CountPairsWithGivenSum {

    int countPairs(int arr[], int target) {
        // Your code here
        HashMap<Integer,Integer> map=new HashMap<>();
        int count=0;
        for(int i:arr)
        {
            if(map.containsKey(target-i))
            {
                count+=map.get(target-i);
            }
            map.put(i,map.getOrDefault(i,0)+1);
        }
        return count;
    }
}
