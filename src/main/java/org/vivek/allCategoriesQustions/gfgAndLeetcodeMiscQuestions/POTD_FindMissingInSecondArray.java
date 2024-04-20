//arr1,arr2 : the arrays
// n, m: size of arrays
// https://www.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1
class POTD_FindMissingInSecondArray
{
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m){
        ArrayList<Integer> res=new ArrayList<>();
        TreeSet<Integer> set=new TreeSet<>();
        for(int a:arr1)  set.add(a);
        for(int b:arr2) set.add(b);
        for(int c:set) res.add(c);
        return res;
    }
}
