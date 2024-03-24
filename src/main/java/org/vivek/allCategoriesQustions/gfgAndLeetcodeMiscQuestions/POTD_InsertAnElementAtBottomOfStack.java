package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

import java.util.Stack;

// https://www.geeksforgeeks.org/problems/insert-an-element-at-the-bottom-of-a-stack/1
public class POTD_InsertAnElementAtBottomOfStack {
    public Stack<Integer> insertAtBottom(Stack<Integer> st, int x) {
        Stack<Integer> temp = new Stack<>();
        while(!st.isEmpty()){
            temp.push(st.peek());
            st.pop();
        }
        st.push(x);
        while(!temp.isEmpty()){
            st.push(temp.peek());
            temp.pop();
        }
        return st;
    }
}
