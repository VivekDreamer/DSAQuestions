package org.vivek.sortingTechniques;

//1. a worst case O(n^2) sorting algorithm
//2. does minimum memory writes and can be useful for the cases where memory writes is costly
//3. in place and not stable
//4. useful to solve question like find min swaps required to sort the array 
public class CycleSort {
    public static void main(String[] args) {
        int arr[] = { 20,40,50,10,30 }; 
        int n = arr.length; 
        cycleSortDistinct(arr, n); 
        for (int i = 0; i < n; i++) 
            System.out.print( arr[i] + " ");
    }

    private static void cycleSortDistinct(int[] arr, int n) {
        for(int cs=0;cs<n-1;cs++){
            int item=arr[cs];
            int pos=cs;
            for(int i=cs+1;i<n;i++)
                if(arr[i]<item)
                    pos++;
            //swap(item,arr[pos])
            
            int temp=item;
            item=arr[pos];
            arr[pos]=temp;
            while(pos!=cs){
                pos=cs;
                for(int i=cs+1;i<n;i++)
                    if(arr[i]<item)
                        pos++;
                        
                //swap(item,arr[pos])
                temp=item;
                item=arr[pos];
                arr[pos]=temp;
            }
        }
    }

}
