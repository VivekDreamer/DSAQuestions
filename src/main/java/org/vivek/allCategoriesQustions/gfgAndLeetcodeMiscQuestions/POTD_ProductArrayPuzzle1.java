class POTD_ProductArrayPuzzle1 {
    public static int[] productExceptSelf(int nums[]) {
        int temp = 1;
        int c = 0; 
        int index = -1;
        for(int i = 0 ;i<nums.length;i++){
            if(nums[i]!=0) temp = temp*nums[i];
            else{
                c++;
                index = i;
            }
        }
        int ans [] = new int[nums.length];
        if(c>1) return ans;
        if(c==1){
            ans[index] = temp;
            return ans;
        }
        for(int i  =0 ; i<nums.length;i++){
            ans[i] = temp/nums[i];
        }
        return ans;
    }
}
