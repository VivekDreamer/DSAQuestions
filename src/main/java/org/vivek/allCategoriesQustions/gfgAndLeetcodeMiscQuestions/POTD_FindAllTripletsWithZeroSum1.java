// https://www.geeksforgeeks.org/problems/find-all-triplets-with-zero-sum/1
public class POTD_FindAllTripletsWithZeroSum1 {
    public List<List<Integer>> findTriplets(int[] arr) {
        List<List<Integer>> answer = new ArrayList<>();

        for (int i =0;i< arr.length;i++)
        {
            Map<Integer,List<Integer>> map = new HashMap<>();
            for (int j = i+1; j< arr.length;j++){
                int sum = (arr[i] + arr[j]) * -1;

                if(map.containsKey(sum)) {
                    for (int k : map.get(sum)) {
                        List<Integer> ans = new ArrayList<>(Arrays.asList(i,j,k));
                        Collections.sort(ans);
                        answer.add(ans);
                    }
                }
                map.putIfAbsent(arr[j],new ArrayList<>());
                map.get(arr[j]).add(j);
            }
        }
        
        return answer;
    }
}
