// https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
class POTD_NMeetingInROom 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int n, int start[], int end[]){
        Meeting[] meetings = new Meeting[n];
        for(int i = 0; i < n; i++){
            meetings[i] = new Meeting(start[i], end[i]);
        }
        Arrays.sort(meetings,(a,b)->a.endTime-b.endTime);
        int count = 1;
        int freeTime = meetings[0].endTime;
        for(int i = 1; i < n; i++){
            if(meetings[i].startTime > freeTime){
                count++;
                freeTime = meetings[i].endTime;
            }
        }
        return count;
    }
    static class Meeting{
        int startTime;
        int endTime;
        public Meeting(int _startTime, int _endTime){
            this.startTime = _startTime;
            this.endTime = _endTime;
        }
    }
}
