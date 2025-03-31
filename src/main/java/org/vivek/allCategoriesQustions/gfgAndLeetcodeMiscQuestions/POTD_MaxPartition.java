class POTD_MaxPartition {
    public int maxPartitions(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        int n = s.length();
        for(int i=0;i<n;i++){
            map.put(arr[i],i);
        }
        int res = 0;
        for(int i=0;i<n;i++){
            int idx = map.get(arr[i]);
            int k=i;
            while(k<idx){
                idx = Math.max(idx,map.get(arr[k]));
                k++;
            }
            res++;
            i = idx;
        }
        return res;
    }
}
