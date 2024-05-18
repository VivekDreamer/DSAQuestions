// https://www.geeksforgeeks.org/problems/find-the-highest-number2259/1
class POTD_FindPeakElement {
    public int findPeakElement(List<Integer> arr) {
        int n = arr.size(); // Size of array
        // Edge cases:
        if (n == 1) return 0;
        if (arr.get(0) > arr.get(1)) return arr.get(0);
        if (arr.get(n - 1) > arr.get(n - 2)) return arr.get(n - 1);

        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            // If arr[mid] is the peak:
            if (arr.get(mid - 1) < arr.get(mid) && arr.get(mid) > arr.get(mid + 1))
                return arr.get(mid);

            // If we are in the left:
            if (arr.get(mid) > arr.get(mid - 1)) low = mid + 1;

            // If we are in the right:
            // Or, arr[mid] is a common point:
            else high = mid - 1;
        }
        // Dummy return statement
        return -1;
    }
}
