// https://www.geeksforgeeks.org/problems/row-with-max-1s0023/1
class POTD_RowWithMaxOne {
    public int rowWithMax1s(int arr[][]) {
        int res = -1;
        int maxOnes = 0;
        for(int i = 0; i < arr.length; i++){
            int countOnes = 0;
            for(int j = 0; j < arr[i].length; j++){
                if(arr[i][j] == 1){
                    countOnes++;
                }
                if(countOnes > maxOnes) {
                    maxOnes = countOnes;
                    res = i;
                }
            }
        }
        return res;
    }
}
