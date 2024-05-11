// https://www.geeksforgeeks.org/problems/juggler-sequence3930/1
class POTD_JugglerSequence {
    static List<Long> jugglerSequence(long n) {
        List<Long> ans = new ArrayList<>();
        ans.add(n);
        while(n > 1){
            if(n % 2 == 0){
                n = (long)Math.pow(n,(float)1/2);
            }else{
                n = (long)Math.pow(n,(float)3/2);
            }
            ans.add(n);
        }
        return ans;
    }
}
