// https://www.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/1
public class POTD_LongestConsecutiveSubsequence {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
      int n = arr.length;
      if(n == 0) return 0;
	    int longest = 1;
	    Set<Integer> set = new HashSet<>();
	    for(int num : arr){
	        set.add(num);
	    }
	    for(int it : set){
	        if(!set.contains(it-1)){
	            //this is the starting point
	            int count = 1;
	            int x = it;
	            while(set.contains(x+1)){
	                x = x + 1;
	                count = count + 1;
	            }
	            longest = Math.max(longest,count);
	        }
	    }
	    return longest;
    }
}
