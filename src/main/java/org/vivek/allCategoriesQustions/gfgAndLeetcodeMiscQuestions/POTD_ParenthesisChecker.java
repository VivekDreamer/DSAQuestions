// https://www.geeksforgeeks.org/problems/parenthesis-checker2744/1
class POTD_ParenthesisChecker
{
    //Function to check if brackets are balanced or not.
    static boolean ispar(String x){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < x.length(); i++){
            if(x.charAt(i) == '(') stack.push(')');
            else if(x.charAt(i) == '{') stack.push('}');
            else if(x.charAt(i) == '[') stack.push(']');
            else {
                if(stack.isEmpty() || x.charAt(i) != stack.pop()) return false;
            }
        }
        return stack.isEmpty();
    }
}
