class Leetcode_RemoveVal {
   public static int removeElement(int[] nums, int val) {
		int count = 0;
		int ans = 0;
		int[] arr = new int[nums.length];
		for(int i = 0; i < arr.length; i++) {
			if(nums[i] != val) {
				arr[count] = nums[i];
				count++;
				ans++;
			}		
		}
		for(int i = 0; i < nums.length; i++) 
			nums[i] = arr[i];
			
		return ans;
	 }
}
