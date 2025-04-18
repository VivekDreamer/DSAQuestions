class POTD_ContainerWithMostWater {
    public int maxWater(int arr[]) {
        if(arr.length==1){
            return 0;
        }
        int i=0;int j=arr.length-1;
        int res=0;
        while(i<j){
            int area=Math.min(arr[i],arr[j])*(j-i);
            res=Math.max(res,area);
            if(arr[i]>arr[j]){
                j--;
            }else if(arr[i]<arr[j]){
                i++;
            }else{
                i++; j--;
            }
        }
        
        return res;
    }
}
