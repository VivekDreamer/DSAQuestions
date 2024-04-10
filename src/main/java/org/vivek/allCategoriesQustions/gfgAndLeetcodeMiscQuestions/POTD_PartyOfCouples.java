// https://www.geeksforgeeks.org/problems/alone-in-couple5507/1
class POTD_PartyOfCouples{
    static int findSingle(int n, int arr[]){
        int N = 0;
        for(int num : arr){
            N = N ^ num; 
        }
        return N;
    }
}
