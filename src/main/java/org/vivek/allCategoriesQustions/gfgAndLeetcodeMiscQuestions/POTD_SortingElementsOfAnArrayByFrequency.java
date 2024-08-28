// https://www.geeksforgeeks.org/problems/sorting-elements-of-an-array-by-frequency-1587115621/1
class POTD_SortingElementsOfAnArrayByFrequency {
    // Function to sort the array according to frequency of elements.
    public ArrayList<Integer> sortByFreq(int arr[]) {
        // add your code here
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i:arr){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            if(hm.get(a)==hm.get(b))return a-b;
            return hm.get(b)-hm.get(a);
        });
        for(Map.Entry<Integer,Integer> entry:hm.entrySet()){
            pq.add(entry.getKey());
        }
        ArrayList<Integer> ans=new ArrayList<>();
        while(!pq.isEmpty()){
            int p=pq.poll();
            int n=hm.get(p);
            while(n-->0){
              ans.add(p);  
            }
        }
        return ans;
    }
}
