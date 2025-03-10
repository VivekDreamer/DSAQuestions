class POTD_EditDis {
    int[][] memo;
    public int editDistance(String s, String t) {
       memo = new int[s.length()+1][t.length()+1];
        for(int[] arr : memo) Arrays.fill(arr,-1);
        return editDistanceUtil(s,t,0,0);
    }
    public int editDistanceUtil(String s, String t, int i, int j){
        if(s.length() == i) return t.length()-j;
        if(t.length() == j) return s.length()-i;
        if(memo[i][j] != -1) return memo[i][j];
        if(s.charAt(i) == t.charAt(j)) return memo[i][j] = editDistanceUtil(s,t,i+1,j+1);
        else{
            int insert = 1 + editDistanceUtil(s,t,i,j+1);
            int remove = 1 + editDistanceUtil(s,t,i+1,j);
            int replace = 1 + editDistanceUtil(s,t,i+1,j+1);
            return memo[i][j] = Math.min(insert,Math.min(remove,replace));
        }
    }
}
