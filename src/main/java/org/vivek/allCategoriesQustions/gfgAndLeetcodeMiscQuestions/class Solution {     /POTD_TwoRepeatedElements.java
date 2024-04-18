// https://www.geeksforgeeks.org/problems/two-repeated-elements-1587115621/1
class POTD_TwoRepeatedElements
{
    //Function to find two repeated elements.
    public int[] twoRepeated(int arr[], int n){
        HashSet<Integer>set = new HashSet<>();
        int res[] = new int[n];
        int index=0;
        for(int i=0;i<arr.length;i++){
            if(set.contains(arr[i])){
                res[index++] = arr[i];
            }
            else{
                set.add(arr[i]);
            }
        }
        return res;
    }
    
}
