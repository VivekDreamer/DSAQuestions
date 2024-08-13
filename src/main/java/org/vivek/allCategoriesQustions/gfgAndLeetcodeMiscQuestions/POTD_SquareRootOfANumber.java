// https://www.geeksforgeeks.org/problems/square-root/1
class POTD_SquareRootOfANumber
{
    long floorSqrt(long x){
		long low = 0;
		long high = x;
		long ans = 1;
		while(low <= high){
		    long mid = low + (high - low)/2;
		    if(mid * mid <= x){
		        ans = mid;
		        low = mid + 1;
		    } else {
		        high = mid - 1;
		    }
		}
		return ans;
	 }
}
