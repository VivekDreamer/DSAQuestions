// https://www.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1
class POTD_MinJumps{
    static int minJumps(int[] arr){
        int jump = 0; 
        int pos = 0;
        int des = 0;
        if(arr.length == 1) return 0;
        if(arr[0] == 0) return -1;
        for(int i = 0; i < arr.length - 1; i++){
            des = Math.max(des, arr[i]+i);
            if(pos == i){
                pos = des;
                jump++;
            }
        }
        if(pos < arr.length-1) return -1;
        return jump;
    }
}
