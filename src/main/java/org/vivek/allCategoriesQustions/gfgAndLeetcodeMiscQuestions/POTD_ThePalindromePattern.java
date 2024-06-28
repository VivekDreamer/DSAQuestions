// https://www.geeksforgeeks.org/problems/the-palindrome-pattern3900/1
class POTD_ThePalindromePattern {
    public String pattern(int[][] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++){
            if(isPalindrome(arr, i, true)) return i + " R";
        }
        for(int i = 0; i < n; i++){
            if(isPalindrome(arr, i, false)) return i + " C";
        }
        return "-1";
    }
    public boolean isPalindrome(int[][] arr, int index, boolean isRow){
        int left = 0;
        int right = arr.length-1;
        while(left < right){
            if(isRow){
                if(arr[index][left] != arr[index][right]) return false;
            }else{
                if(arr[left][index] != arr[right][index]) return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
