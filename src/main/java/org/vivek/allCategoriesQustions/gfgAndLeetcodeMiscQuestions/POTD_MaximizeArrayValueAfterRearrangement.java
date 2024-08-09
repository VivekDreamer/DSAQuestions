// https://www.geeksforgeeks.org/problems/maximize-arrii-of-an-array0026/1
class POTD_MaximizeArrayValueAfterRearrangement {
    int Maximize(int arr[]) {
        Arrays.sort(arr);
        long store=0;
       long mod=1000000007;
        for(int i=0;i<arr.length;i++)
        {
           store=(store+(long)arr[i]*i) %mod;
        }
        return (int)store;
    }
}
