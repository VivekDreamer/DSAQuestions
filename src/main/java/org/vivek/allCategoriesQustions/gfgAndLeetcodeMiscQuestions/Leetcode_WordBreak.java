class Leetcode_WordBreak {
    private Boolean[] memo;
    int n;
    public boolean wordBreak(String s, List<String> wordDict) {
        n = s.length();
        memo = new Boolean[s.length()];
        return wordBreakUtil(s, 0, wordDict);
    }
    
    private boolean wordBreakUtil(String s, int idx, List<String> wordDict) {
        if (idx == n) return true;
        
        if (memo[idx] != null) return memo[idx];
        
        for (int endIdx = idx + 1; endIdx <= n; endIdx++) {
            String split = s.substring(idx, endIdx);
            if (wordDict.contains(split) && wordBreakUtil(s, endIdx, wordDict)) return memo[idx] = true;   
        }
        
        return memo[idx] = false;
    }
}
