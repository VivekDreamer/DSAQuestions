// https://www.geeksforgeeks.org/problems/merge-two-bst-s/1
class POTD_MergeTwoBSTs
{
    //Function to return a list of integers denoting the node 
    //values of both the BST in a sorted order.
    public List<Integer> merge(Node root1,Node root2)
    {
        // Write your code here
        List<Integer> FirstBst = new ArrayList<>();
        List<Integer> SecondBst = new ArrayList<>();
        List<Integer> MergedBst = new ArrayList<>();
        inorderBst(root1,FirstBst);
        inorderBst(root2,SecondBst);
        //Collections.sort(list);
        mergeTwoSortedList(FirstBst,SecondBst,MergedBst);
        return MergedBst;
    }
    void inorderBst(Node root, List<Integer> list){
        if(root == null)return;
        inorderBst(root.left,list);
        list.add(root.data);
        inorderBst(root.right,list);
    }
    void mergeTwoSortedList(List<Integer> FirstBst, List<Integer> SecondBst, List<Integer> MergedBst){
        int i=0,j=0;
        while(i < FirstBst.size() && j < SecondBst.size()){
            if(FirstBst.get(i)<SecondBst.get(j)){
                MergedBst.add(FirstBst.get(i));
                i++;
            }
            else{
                MergedBst.add(SecondBst.get(j));
                j++;
            }
        }
        while(i < FirstBst.size()){
            MergedBst.add(FirstBst.get(i));
            i++;
        }
        while(j < SecondBst.size()){
            MergedBst.add(SecondBst.get(j));
            j++;
        }
    }
}
