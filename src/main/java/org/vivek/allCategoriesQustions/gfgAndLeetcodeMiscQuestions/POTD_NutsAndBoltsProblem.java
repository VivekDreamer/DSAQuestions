// https://www.geeksforgeeks.org/problems/nuts-and-bolts-problem0431/1
class POTD_NutsAndBoltsProblem {
    /*void matchPairs(int n, char nuts[], char bolts[]) {
        Arrays.sort(nuts);
        Arrays.sort(bolts);
    }*/
    
    void matchPairs(int n, char nuts[], char bolts[]) {
        char[] arr = {'!','#','$','%','&','*','?','@','^'};
        HashSet<Character> set = new HashSet<>();
        for(char ch : nuts){
            set.add(ch);
        }
        int k = 0;
        for(int i = 0; i < arr.length; i++){
            if(set.contains(arr[i])){
                nuts[k]  = arr[i];
                bolts[k] = arr[i];
                k++;
            }
        }
    }
}
