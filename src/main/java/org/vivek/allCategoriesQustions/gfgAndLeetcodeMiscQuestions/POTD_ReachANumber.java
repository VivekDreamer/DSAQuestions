https://www.geeksforgeeks.org/problems/minimum-number-of-steps-to-reach-a-given-number5234/1
class POTD_ReachANumber {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int steps = 0;
        int sum = 0;
        while(sum < target || (sum-target)%2 != 0){
            steps++;
            sum+=steps;
        }
        return steps;
    }
}
