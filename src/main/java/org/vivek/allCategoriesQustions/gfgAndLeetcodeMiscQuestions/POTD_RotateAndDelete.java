// https://www.geeksforgeeks.org/problems/rotate-and-delete-1587115621/1
class POTD_RotateAndDelete {
    public static int rotateDelete(ArrayList<Integer> arr) {
        int n=arr.size(),temp=n/2;
        int i=3*(temp/2);
        if(temp%2==1) i++;
        return arr.get(n-i);
    }
}
