// https://www.geeksforgeeks.org/problems/swapping-pairs-make-sum-equal4142/1
class POTD_SwappingPairsMakeSumEqual { 
    boolean isPresent(long[] arr,long target){
        int l=0,h=arr.length-1;
        while(l<=h){
            int mid = l + (h-l)/2;
            if(arr[mid]==target) return true;
            else if(arr[mid]<target) l = mid + 1;
            else h = mid -1 ;
        }
        return false;
    }
    
    long findSwapValues(long a[], int n, long b[], int m) {
        long sum1 = Arrays.stream(a).sum();
        long sum2 = Arrays.stream(b).sum();
        long diff = Math.abs(sum1-sum2);
        //if diff bet sum of arr a & b is odd then return -1 as we cant make equal using above given condition
        if(diff%2!=0) return -1;
        //sort array so we can use binary search for searching our target value
        Arrays.sort(a);
        Arrays.sort(b);
        //target is half of diff as we can add half on one side while subtract on other side to make it equal
        long target=diff/2;
        if(sum1<sum2){ 
            for(long x:a){
                if(isPresent(b,x+target)) return 1;
            }
        }else{
            for(long y:b){
                if(isPresent(a,y+target)) return 1;
            }
        }
        return -1;
    }
}
