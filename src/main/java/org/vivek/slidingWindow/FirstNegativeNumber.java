package org.vivek.slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//first negative number in every window of size k
public class FirstNegativeNumber {
    public static void main(String[] args) {
        int N = 8;
        long A[] = {12, -1, -7, 8, -15, 30, 16, 28};
        int K = 3;
        long[] printFirstNegativeInteger = printFirstNegativeInteger(A, N, K);
        System.out.println(Arrays.toString(printFirstNegativeInteger));
    }
    public static long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        Queue<Long> queue = new LinkedList<>();
        List<Long> ans = new ArrayList<>();
        long i = 0, j = 0;
        while(j < N){
            if(A[(int)j] < 0)queue.add(A[(int)j]);
            if(j - i + 1 < K){
                j++;
            }
            else{
                if(queue.isEmpty()) ans.add(0L);
                else{
                    ans.add(queue.peek());
                    if(queue.peek().equals(A[(int)i])) queue.poll();
                }
                i++;
                j++;
            }
        }
        long[] result = new long[ans.size()];
        for(int k = 0; k < ans.size(); k++) result[k] = ans.get(k); 
        return result;
    }
}
