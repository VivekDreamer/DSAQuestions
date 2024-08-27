// https://www.geeksforgeeks.org/problems/maximum-difference-1587115620/1
class POTD_MinimumDifference {
    public int findMaxDiff(int[] arr) {
        // code here
        Stack<Integer>st = new Stack<>();
        int ans = 0;
        for(int rightSmaller:arr){
            while(!st.isEmpty() && st.peek()>rightSmaller){
                int current = st.pop();
                int leftSmaller = 0;
                while(!st.isEmpty() && st.peek()==current){
                    st.pop();
                }
                leftSmaller = (st.isEmpty()?0:st.peek());
                ans = Math.max(ans,(int)Math.abs(rightSmaller-leftSmaller));
            }
            st.push(rightSmaller);
        }
        while(!st.isEmpty()){
                int current = st.pop();
                if(!st.isEmpty() && st.peek()==current){
                    continue;
                }
                int leftSmaller = (st.isEmpty()?0:st.peek());
                ans = Math.max(ans,leftSmaller);
        }
        return ans;
    }
}
