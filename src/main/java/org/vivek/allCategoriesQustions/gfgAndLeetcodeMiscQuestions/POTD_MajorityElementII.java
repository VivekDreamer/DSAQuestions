// https://www.geeksforgeeks.org/problems/majority-vote/1
public class POTD_MajorityElementII {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(int[] nums) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = nums.length;
        int m = n/3;
        for(int i = 0; i < n; i++)
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        for(int k : hm.keySet()) {
            if(hm.get(k) > m)
                list.add(k);
        }
        Collections.sort(list);
        return list;
    }
}
