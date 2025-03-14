class Leetcode_GenerateParenthesi {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesisUtil(0,0,"",res,n);
        return res;
    }
    public void generateParenthesisUtil(int left, int right, String res, List<String> ans, int n){
        if(res.length() == n*2){
            ans.add(res);
            return;
        }
        if(left < n){
            generateParenthesisUtil(left+1,right,res+"(",ans,n);
        }
        if(right < left){
            generateParenthesisUtil(left,right+1,res+")",ans,n);
        }
    }
}
