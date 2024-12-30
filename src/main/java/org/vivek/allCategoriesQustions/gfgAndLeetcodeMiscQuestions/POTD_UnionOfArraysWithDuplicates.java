// https://www.geeksforgeeks.org/problems/union-of-two-arrays3538/1
class POTD_UnionOfArraysWithDuplicates
 {
    public static int findUnion(int a[], int b[]) {
        // code here
        int n = a.length;
        int m = b.length;
        Set<Integer> set = new HashSet<>();
        int length = n>m?n:m;
        for(int i = 0; i < length; i++){
            if(i < n) set.add(a[i]);
            if(i < m) set.add(b[i]);
        }
        return set.size();
    }
}
