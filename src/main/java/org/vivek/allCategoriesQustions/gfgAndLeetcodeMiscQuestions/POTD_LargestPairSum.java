// https://www.geeksforgeeks.org/problems/pair-sum--120604/1
public class POTD_LargestPairSum {
    public static int pairsum(int[] arr) {
        int first=-1,second=-1;
        for(int i: arr){
            if(i>first){
                first=i;
            }
        }
        for(int i: arr){
            if(i==first){
                i=-1;
            }
            if(i>second){
                second=i;
            }
        }
        return first+second;
    }
}
