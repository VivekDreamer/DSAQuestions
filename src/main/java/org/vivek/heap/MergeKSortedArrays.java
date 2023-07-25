package org.vivek.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedArrays {
    public static void main(String[] args) {
        List<List<Integer> > arr=new ArrayList<>();
	    List<Integer> a1 = new ArrayList<>(); 
        a1.add(10); 
        a1.add(20);
        a1.add(30);
        arr.add(a1); 
  
        List<Integer> a2 = new ArrayList<>(); 
        a2.add(5);
        a2.add(15);
        arr.add(a2); 
  
        List<Integer> a3 = new ArrayList<>(); 
        a3.add(1); 
        a3.add(9); 
        a3.add(11);
        a3.add(18);
        arr.add(a3);
        
        List<Integer> res = mergeArr(arr); 
  
        System.out.println("Merged array is " ); 
        for (int x : res) 
            System.out.print(x + " ");
    }
    public static List<Integer> mergeArr(List<List<Integer>> list){
        List<Integer> res = new ArrayList<>();
        //minHeap
        Queue<Triplet> queue = new PriorityQueue<>();
        for(int i = 0; i < list.size(); i++){
            queue.add(new Triplet(list.get(i).get(0), i, 0));
        }
        while(!queue.isEmpty()){
            Triplet curr = queue.poll();
            res.add(curr.val);
            int arrp = curr.arrPos; 
            int verp = curr.verPos;
            if(verp+1 < list.get(arrp).size())
                queue.add(new Triplet(list.get(arrp).get(verp+1), arrp, verp+1));
        }
        return res;
    }
    static class Triplet implements Comparable<Triplet>{
        Integer val;
        //index of each array in list
        Integer arrPos;
        //index of each element in the array
        Integer verPos;
        public Triplet(int val, int arrPos, int verPos) {
            this.val = val;
            this.arrPos = arrPos;
            this.verPos = verPos;
        }
        @Override
        public int compareTo(Triplet o) {
            if(val<=o.val)return -1;
            else return 1;
        }
        
    }
}
