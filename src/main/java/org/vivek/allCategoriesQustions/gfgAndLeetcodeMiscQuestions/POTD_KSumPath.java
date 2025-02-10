public class POTD_KSumPath
{
    int res = 0;
    public int sumK(Node root,int k)
    {
        // code here 
        ArrayList<Integer> list = new ArrayList<>();
        solve(root,k,list);
        return res;
    }
    public void solve(Node root, int k, ArrayList<Integer> list){
        if(root == null)return;
        list.add(root.data);
        int sum = 0;
        for(int i = list.size()-1;i>=0;i--){
            sum+=list.get(i);
            if(sum==k)res++;
        }
        solve(root.left,k,list);
        solve(root.right,k,list);
        list.remove(list.size()-1);
        
    }
}
