package org.vivek.allCategoriesQustions.amazonQuestions;

import java.util.Stack;

// Get minimum element from the stack
// https://practice.geeksforgeeks.org/problems/get-minimum-element-from-stack/1

//by using extra space i.e, supportingStack
/*
public class GetMinimumElementFromStack {
    Stack<Integer> originalStack;
    Stack<Integer> supportingStack;

    public GetMinimumElementFromStack() {
        this.originalStack = new Stack<>();
        this.supportingStack = new Stack<>();
    }

    public void push(int x){
        originalStack.push(x);
        if(supportingStack.size() == 0 || x <= supportingStack.peek()){
            supportingStack.push(x);
        }
    }

    public int pop(){
        if(originalStack.size() == 0) return -1;
        int ans = originalStack.peek();
        originalStack.pop();
        if(ans == supportingStack.peek()){
            supportingStack.pop();
        }
        return ans;
    }

    public int getMinElement(){
        if(supportingStack.size() == 0) return -1;
        return supportingStack.peek();
    }
    
}
*/

//using constant space - O(1)
public class GetMinimumElementFromStack {
    Stack<Integer> stack;
    int minElement;
    
    public GetMinimumElementFromStack() {
        this.stack = new Stack<>();
    }
    
    public int getMinimumElement(){
        if(stack.size() == 0) return -1;
        return minElement;
    }

    public void push(int x){
        if(stack.size() == 0){
            minElement = x;
            stack.push(x);
        } else {
            if(x >= stack.peek()){
                stack.push(x);
            } else {
                stack.push(2 * x - minElement);
                minElement = x;
            }
        }
    }

    public int pop(){
        int x = 0;
        if(stack.size() == 0) return -1;
        else {
            if(stack.peek() >= minElement){
                x = stack.peek();
                stack.pop();
            } else if (stack.peek() < minElement){
                x = minElement;
                minElement = 2 * minElement - stack.peek();
                stack.pop();
            }
        }
        return x;
    }
    
    public int peek(){
        int x = 0;
        if(stack.size() == 0){
            return -1;
        } else {
            if(stack.peek() >= minElement){
                x = stack.peek();
            } else if (stack.peek() < minElement) {
                x = minElement;
            }
        }
        return x;
    }
}