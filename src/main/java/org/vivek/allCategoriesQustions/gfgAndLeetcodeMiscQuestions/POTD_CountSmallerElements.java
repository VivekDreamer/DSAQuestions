// https://www.geeksforgeeks.org/problems/count-smaller-elements2214/1
class POTD_CountSmallerElements {
    int[] constructLowerArray(int[] arr) {
        int[] res=new int[arr.length];
        for(int i=0;i<arr.length-1;i++){
            int a=arr[i];
            int c=0;
            for(int j=i+1;j<arr.length;j++){
                if(a>arr[j]) c++;    
            }
            res[i]=c;
        }
        return res;
    }
}
