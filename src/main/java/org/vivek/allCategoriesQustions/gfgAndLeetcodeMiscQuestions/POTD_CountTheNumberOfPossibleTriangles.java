// https://www.geeksforgeeks.org/problems/count-possible-triangles-1587115620/1
public class POTD_CountTheNumberOfPossibleTriangles {
    // Function to count the number of possible triangles.
    static int countTriangles(int arr[]) {
        Arrays.sort(arr);
        int ans=0;
        for(int i=arr.length-1;i>=0;i--){
            int st=0, end=i-1;
            while(st<end){
                if(arr[st]+arr[end]>arr[i]){
                    ans+=end-st;
                    end--;
                }
                else {
                    st++;
                }
            }
        }
        return ans;
    }
}
