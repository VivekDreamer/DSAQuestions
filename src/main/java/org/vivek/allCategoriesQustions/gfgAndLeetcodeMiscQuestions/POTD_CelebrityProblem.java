// https://www.geeksforgeeks.org/problems/the-celebrity-problem/1
class POTD_CelebrityProblem {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int M[][]) {
        // code here
        Stack<Integer> stack = new Stack<>();
    	for(int i = 0; i < M.length; i++){
    	    stack.push(i);
    	}
    	
    	while(stack.size() >= 2){
    	    int i = stack.pop();
    	    int j = stack.pop();
    	    if(M[i][j] == 1){
    	        //if i knows j then i is not the celebrity
    	        stack.push(j);
    	    } else {
    	        //if i does not knows j then, i may be the celebrity
    	        stack.push(i);
    	    }
    	}
    	
    	int potentialCelebrity = stack.pop();
    	for(int i = 0 ; i < M.length; i++){
    	    if(i != potentialCelebrity){
    	        if(M[i][potentialCelebrity] == 0 || M[potentialCelebrity][i] == 1){
    	            // it means that we do not have any celebrity
    	            return -1;
    	        }
    	    }
    	}
    	
    	return potentialCelebrity;
    }
}
