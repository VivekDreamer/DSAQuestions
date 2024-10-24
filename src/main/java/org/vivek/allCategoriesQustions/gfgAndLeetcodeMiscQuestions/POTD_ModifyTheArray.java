// https://www.geeksforgeeks.org/problems/ease-the-array0633/1
public class POTD_ModifyTheArray {
    static ArrayList<Integer> modifyAndRearrangeArr(int arr[]) {
        int n = arr.length;
        for(int i = 0; i<n-1; i++){
            if(arr[i] != 0 && (arr[i] == arr[i+1])){
                arr[i] = 2*arr[i];
                arr[i+1] = 0;
            }
        }
        ArrayList<Integer> ls = new ArrayList<>();
        int count = 0;
        for(int i = 0; i<n; i++){
            if(arr[i] != 0){
                ls.add(arr[i]);
            }
            else count++;
        }
        for(int i = 0; i<count; i++){
            ls.add(0);
        }
        return ls;
    }
}
