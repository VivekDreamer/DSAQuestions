// https://www.geeksforgeeks.org/problems/remove-duplicates-in-small-prime-array/1
public class POTD_RemoveDuplicatesInArray {
    ArrayList<Integer> removeDuplicate(int arr[]) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : arr){
            if(!set.contains(num)){
                list.add(num);
                set.add(num);
            }
        }
        return list;
    }
}
