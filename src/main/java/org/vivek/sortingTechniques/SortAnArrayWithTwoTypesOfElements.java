package org.vivek.sortingTechniques;

public class SortAnArrayWithTwoTypesOfElements {
    public static void main(String[] args) {
        //segregate positive and negative
        //i/p : {15,-3,-2,18}
        //o/p : {-3,-2,15,18}
        
        //segrgate the even and odd
        //i/p : {15,14,13,12}
        //o/p : {14,12,15,13}

        //segregate the binary array
        //i/p : {0,1,1,1,0}
        //o/p : {0,0,1,1,1}

        //in this we will segregate the positives and negatives
        //below problem is solve similarily
        int arr[] = new int[]{13,-12,18,-10};
        int n = arr.length;
        // sort(arr,n);
	    // for(int x:arr)
        //     System.out.print(x+" ");
        sortEfficient(arr,n);
        for(int x:arr)
            System.out.print(x+" ");
    }
    //naive approach
    private static void sort(int[] arr, int n) {
        int[] temp = new int[n];
        int i = 0;
        for(int j = 0; j < n; j++){
            if(arr[j] < 0)temp[i++] = arr[j];
        }
        for(int j = 0; j < n; j++){
            if(arr[j] >= 0)temp[i++] = arr[j];
        }
        for(int j = 0; j < n; j++){
            arr[j] = temp[j];
        }
    }

    //efficient approach by using partition algorithm of quick sort either lomuto or hoares
    private static void sortEfficient(int[] arr, int n) {
        int i = -1; int j = n;
        while(true){
            do{i++;}while(arr[i] < 0);
            do{j--;}while(arr[j] >= 0);
            if(i >= j)return;
            //swapping arr[i] and arr[j]
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

}
