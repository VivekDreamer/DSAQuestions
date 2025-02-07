public class Leetcode_SortColors {
    public void sortColors(int[] nums) {
        for(int i = 0; i < nums.length-1; i++){
            int temp = 0;
            int minIndex = i;
            for(int j = i+1; j < nums.length; j++){
                if(nums[j] < nums[minIndex])
                    minIndex = j;
            }
            temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }
    }
}
