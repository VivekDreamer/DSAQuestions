class POTD_ActivitySelection {
 class pair implements Comparator<pair>{
        int s;
        int e;
        public pair(int s, int e){
            this.s=s;
            this.e=e;
        }
        public int compare(pair o1, pair o2){
            if(o1.e==o2.e){
                return o1.s-o2.s;
            }else return o1.e-o2.e;
        }
    }
    
    public int activitySelection(int[] start, int[] finish) {
        int n=start.length;
        pair arr[]=new pair[n];
        for(int i=0;i<n;i++){
            arr[i]=new pair(start[i], finish[i]);
        }
        
        Arrays.sort(arr, new pair(0, 0));
        
        int cnt=0;
        int end=Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++){
            if(end<arr[i].s){
                cnt++;
                end=arr[i].e;
            }
        }
        return cnt;
    }
}
