// https://www.geeksforgeeks.org/problems/count-the-elements1529/1
class POTD_CountTheElements
{
    public static int[] countElements(int a[], int b[], int n, int query[], int q){
        int[] count = new int[100001];
        for(int i = 0; i < n; i++){
            count[b[i]]++;
        }
        for(int i = 1; i < count.length; i++){
            count[i] += count[i-1];
        }
        int[] result = new int[q];
        for(int i = 0; i < q; i++){
            int index = query[i];
            int value = a[index];
            result[i] = count[value];
        }
        return result;
    }
}
