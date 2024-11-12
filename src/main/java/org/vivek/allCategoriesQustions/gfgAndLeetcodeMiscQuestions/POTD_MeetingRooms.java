// https://www.geeksforgeeks.org/problems/attend-all-meetings/1
public class POTD_MeetingRooms {
    static boolean canAttend(int[][] arr) {
        int n = arr.length;
        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
        for(int i = 1; i < n; i++) {
            if(arr[i-1][1] > arr[i][0]) return false;
        }
        return true;
    }
}
