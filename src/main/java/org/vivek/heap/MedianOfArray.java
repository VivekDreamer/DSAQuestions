package org.vivek.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfArray {
    public static void main(String[] args) {
        double[] arr=new double[]{25,7,10,15,20};
        int n=5;
        double[] temp=new double[n];
        int size=0;
        for(int i = 0; i < n; i++){
            temp[i] = arr[i];
            size++;
            int j = i;
            while(j > 0 && temp[j] < temp[j-1]){
                double a = temp[j];
                temp[j] = temp[j-1];
                temp[j-1] = a;
                j--;
            }
            if(size%2 != 0){
                System.out.print(temp[size/2]+" ");
            }
            else{
                System.out.print(((temp[size/2]+temp[(size-1)/2])/2) + " ");
            }
        }

        System.out.println();
        printMedian(arr, n);
    }

    //time complexity = O(nlogn)
    public static void printMedian(double[] arr, int n){
        //In this we have two containers and I'm going to put smaller half element in first container and 
        //greater half element in second container..If there are odd number of elements then, I'm going to
        //put that extra element in first container
        PriorityQueue<Double> g = new PriorityQueue<>(); //this will contain the greater half element
        PriorityQueue<Double> s = new PriorityQueue<>(Collections.reverseOrder());  //this will contain the smaller half element
        s.add(arr[0]);
        System.out.print(arr[0]+" ");
        for(int i = 1; i < n; i++){
            double x = arr[i];
            if(s.size()>g.size()){
                if(s.peek()>x){
                    g.add(s.poll());
                    s.add(x);
                }
                else{
                    g.add(x);
                }
                System.out.print((double)((s.peek()+g.peek())/2)+" ");
            }
            else{
                if(x<=s.peek()){
                    s.add(x);
                }else{
                    g.add(x);
                    s.add(g.poll());
                }
                System.out.print(s.peek()+" ");
            }
        }
    }
}
