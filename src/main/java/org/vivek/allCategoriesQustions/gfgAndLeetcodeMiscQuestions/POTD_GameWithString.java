package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

import java.util.PriorityQueue;
import java.util.Queue;

// https://www.geeksforgeeks.org/problems/game-with-string4100/1
public class POTD_GameWithString {
    static int minValue(String s, int k){
        Queue<Integer> pq = new PriorityQueue<>((a,b) -> (b.compareTo(a)));
        int[] freq = new int[26];
        for(char ch:s.toCharArray())freq[ch-'a']++;
        for(int ch : freq) pq.add(ch);
        while(k-->0) pq.add(pq.poll()-1);
        int sum = 0;
        while(!pq.isEmpty()){
            sum += (pq.peek()*pq.peek());
            pq.remove();
        }
        return sum;
    }
}
