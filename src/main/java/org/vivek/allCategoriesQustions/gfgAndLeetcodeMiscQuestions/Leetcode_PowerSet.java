// https://leetcode.com/problems/subsets/submissions/1608578437/
public class Leetcode_PowerSet {
  // code to list down all the subset or subsequence of a array
  public List<List<Integer>> subset(int[] nums) {
      List<List<Integer>> res = new ArrayList<>();
      List<Integer> ans = new ArrayList<>();
      subsetUtil(0,nums,ans,res);
      return res;
  }
  public void subsetUtil(int idx, int[] nums, List<Integer> ans, List<List<Integer>> res) {
      if(idx == nums.length) {
          res.add(new ArrayList<>(ans));
          return;
      }
      ans.add(nums[idx]);
      subsetUtil(idx+1,nums,ans,res);
      ans.remove(ans.size() - 1);
      subsetUtil(idx+1,nums,ans,res);
  }

  //code to list down all the subset using bit masking
  public List<List<Integer>> subset(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    int n = nums.length;
    for (int mask = 0; mask < (1 << n); mask++) {
        List<Integer> subset = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) != 0) {
                subset.add(nums[i]);
            }
        }
        res.add(subset);
    }
    return res;
}


  // code to list down all the subsequence of a string
  public List<String> allSubsequence(String str) {
      List<String> res = new ArrayList<>();
      String temp = "";
      allSubsequenceUtil(0,str,temp,res);
      return res;
  }
  public void allSubsequenceUtil(int idx, String str, String temp, List<String> res) {
      if(idx == str.length()){
          res.add(temp);
          return;
      }
      // Include the current character
      allSubsequenceUtil(idx + 1, str, temp + str.charAt(idx), res);
      // Exclude the current character
      allSubsequenceUtil(idx + 1, str, temp, res);
  }

  // you can use bit manipulation also
  // T.C. = O(2ⁿ * n)
  public List<String> allSubSequence1(String str) {
      int n = str.length();
      List<String> res = new ArrayList<>();
      for(int num = 0; num < (1 << n); num++) {
          StringBuilder sb = new StringBuilder();
          for(int i = 0; i < n; i++) {
              if((num & (1 << i) != 0){
                  sb.append(str.charAt(i));
              }
          }
          res.add(sb.toString());
      }
      return res;
  }
}

