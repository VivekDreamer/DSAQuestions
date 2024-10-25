// https://www.geeksforgeeks.org/problems/alternative-sorting1311/1
public class POTD_AlternativeSorting {
    public static ArrayList<Integer> alternateSort(int[] arr) {
        int n = arr.length;
        int left = 0,right = n-1;
        Arrays.sort(arr);
        ArrayList<Integer> lt = new ArrayList<>();
        while(left < right){
            lt.add(arr[right]);
            lt.add(arr[left]);
            left++;
            right--;
        }
        if(left == right) lt.add(arr[left]);
        return lt;
    }
}
