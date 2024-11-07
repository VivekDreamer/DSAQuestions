// https://www.geeksforgeeks.org/problems/split-array-in-three-equal-sum-subarrays/1
public class POTD_SplitArrayInThreeEqualSumSubarrays {

    /*public List<Integer> findSplit(int[] arr) {
        // Return an array of possible answer, driver code will judge and return true or
        // false based on
        int left =0,right=arr.length-1;
        int leftsum =arr[0],rightsum=arr[right];
        int totalsum =0;
        for(int i =0;i<arr.length;i++){
            totalsum += arr[i];
        }
        while(left<right){
            if(leftsum == rightsum && leftsum ==( totalsum - 2*leftsum)){
                return new ArrayList<>(Arrays.asList(left,right-1));
            }else if(leftsum>rightsum){
                rightsum += arr[--right];
            }else{
                leftsum += arr[++left];
            }
        }
        return new ArrayList<>(Arrays.asList(-1, -1)); 
    }*/
    
    public List<Integer> findSplit(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        int sum = 0;
        for(int x : arr) sum+=x;
        if(sum % 3 != 0){
            ans.add(-1);
            ans.add(-1);
            return ans;
        }
        int requiredSum = sum/3;
        sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(sum == requiredSum){
                ans.add(i);
                if(ans.size() == 2) break;
                sum = 0;
            }
        }
        if(ans.size() == 2) return ans;
        ans.clear();
        ans.add(-1);
        ans.add(-1);
        return ans;
    }
    
}
