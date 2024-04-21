// https://www.geeksforgeeks.org/problems/three-way-partitioning/1
class POTD_ThreeWayPartitioning{
    //Function to partition the array around the range such 
    //that array is divided into three parts.
    public void threeWayPartition(int array[], int a, int b){
        int i = 0, j = 0, k = array.length-1;
        while(i <= k){
            if(array[i] < a){
                swap(array,i,j);
                i++;
                j++;
            }else if(array[i] > b){
                swap(array, i, k);
                k--;
            }else i++;
        }
    }
    public void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
