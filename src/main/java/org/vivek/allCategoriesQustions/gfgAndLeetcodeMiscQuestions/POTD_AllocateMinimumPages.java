class POTD_AllocateMinimumPages {
    public static int findPages(int[] arr, int m) {
        int n = arr.length;
        if(m > n) return -1;
        int low = Arrays.stream(arr).max().orElse(Integer.MIN_VALUE);
        int high = Arrays.stream(arr).sum();
        while(low <= high){
            int mid = low + (high-low)/2;
            int students = countStudent(arr,mid);
            if(students > m) low = mid+1;
            else high = mid-1;
        }
        return low;
    }
    public static int countStudent(int[] arr, int pages){
        int n = arr.length;
        int students = 1;
        int pagesStudent = 0;
        for(int i = 0; i < n; i++){
            if(pagesStudent + arr[i] <= pages){
                pagesStudent += arr[i];
            }else{
                
                students++;
                pagesStudent = arr[i];
                // if(pages == 25)
                // System.out.println(pages +" ::: "+ students+ " :::: "+pagesStudent);
            }
        }
        // System.out.println(pages +" : "+ students);
        return students;
    }
}
