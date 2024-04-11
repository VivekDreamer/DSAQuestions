// https://www.geeksforgeeks.org/problems/gray-to-binary-equivalent-1587115620/1
class GrayToBinaryEquivalent{
    // function to convert a given Gray equivalent n to Binary equivalent.
    public static int grayToBinary(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        while(n!=0){
            if((n&1)==1)arr.add(1);
            else arr.add(0);
            n>>=1;
        }
        Collections.reverse(arr);
        for(int i = 1; i < arr.size(); i++){
            int a = arr.get(i-1);
            int b = arr.get(i);
            arr.set(i,a^b);
        }
        int ans = 0, j = 0;
        for(int i = arr.size()-1; i >=0; i--){
            if(arr.get(i)==1)ans+=Math.pow(2,j);
            j++;
        }
        return ans;
    }
}
