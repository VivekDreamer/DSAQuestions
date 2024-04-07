//https://www.geeksforgeeks.org/problems/maximize-dot-product2649/1
class POTD_MaximizeDotProduct
{
  int[][] memo;
	public int maxDotProduct(int n, int m, int a[], int b[]) 
	{ 
	    memo = new int[n][m];
	    for(int[] arr : memo) Arrays.fill(arr,-1);
	    return maxDotProductUtil(0,0,n,m,a,b,n-m);
	} 
	public int maxDotProductUtil(int i, int j, int n, int m, int[] a, int[] b, int diff){
	    if(i == n || j == m) return 0;
	    if(memo[i][j] != -1) return memo[i][j];
	    int sum1 = 0, sum2 = 0;
	    if(diff != 0) sum1 = maxDotProductUtil(i+1,j,n,m,a,b,diff-1);
	    sum2 = a[i]*b[j] + maxDotProductUtil(i+1,j+1,n,m,a,b,diff);
	    return memo[i][j] =  Math.max(sum1,sum2);
	}
}
