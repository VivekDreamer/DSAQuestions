// https://www.geeksforgeeks.org/problems/reorganize-the-array4810/1
public class POTD_ReorganizeTheArray {
    public List<Integer> rearrange(List<Integer> arr) {
        for(int i=0; i<arr.size(); i++){
            while(arr.get(i)!=-1 && arr.get(i)!=i){
                int correctIndex = arr.get(i);
                if(arr.get(correctIndex) == correctIndex){
                    break;
                }
                int temp = arr.get(i);
                arr.set(i, arr.get(correctIndex));
                arr.set(correctIndex, temp);
            }
        }
        
        for(int i=0; i<arr.size(); i++){
            if(arr.get(i)!=i){
                arr.set(i, -1);
            }
        }
        return arr;
    }
}
