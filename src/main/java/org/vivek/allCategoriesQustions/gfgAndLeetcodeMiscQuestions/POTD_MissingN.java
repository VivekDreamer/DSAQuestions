class POTD_MissingN {
    int missingNum(int arr[]) {
       int sum=0;
       for(int i=1;i<=arr.length;i++){
           sum=sum^i^arr[i-1];
       }
       return sum^arr.length+1;
    }
}
