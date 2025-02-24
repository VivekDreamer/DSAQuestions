// https://www.geeksforgeeks.org/problems/stock-span-problem-1587115621/1
public class POTD_StockSpanProblem {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>(arr.length);
        for(int i = 0; i < arr.length; i++){
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                ans.add(i - stack.peek());
            }else{
                ans.add(i+1);
            }
            stack.add(i);
        }
        return ans;
    }
}
