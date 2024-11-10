// https://www.geeksforgeeks.org/problems/union-of-two-sorted-arrays-with-distinct-elements/1
public class POTD_UnionOfTwoSortedArraysWithDistinctElements {
    // Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer>ans = new ArrayList<>();
        int i=0,j=0;
        while(i<a.length && j<b.length){
            if(a[i]==b[j]){
                ans.add(a[i]);
                i++;
                j++;
            }else if(a[i]<b[j]){
                ans.add(a[i]);
                i++;
            }else{
                ans.add(b[j]);
                j++;
            }
        }
        while(i<a.length)ans.add(a[i++]);
        while(j<b.length)ans.add(b[j++]);
        
        return ans;
    }
}
