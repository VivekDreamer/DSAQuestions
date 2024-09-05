// https://www.geeksforgeeks.org/problems/missing-number-in-array1416/1
public class POTD_MissingNumber{
  int missingNumber(int n, int array[]) {
        int sum = n*(n+1)/2;
        int s = Arrays.stream(array).sum();
        return sum-s;
    }
}
