// https://www.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1
class POTD_Sort0S1S2S {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(ArrayList<Integer> arr) {
        // code here
        int low=0;
        int mid=0;
        int high=arr.size()-1;
        while(mid<= high)
        {
            if(arr.get(mid)==0)
            {
                Collections.swap(arr,low,mid);
                mid++;low++;
            }
            else if(arr.get(mid)==1)
                mid++;
            else if(arr.get(mid)==2)
            {
                Collections.swap(arr,mid,high);
                high--;
            }
        }
    }
}
