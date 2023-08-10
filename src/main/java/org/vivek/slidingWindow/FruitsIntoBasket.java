package org.vivek.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBasket {
    public static void main(String[] args) {
        int[] fruits = {1,2,3,2,2};
        int totalFruit = totalFruit(fruits);
        System.out.println("answer : "+totalFruit);
    }
    //simple problem based on variable size sliding window
    //same problem as that of  
    //1. pick toys
    //2. Longest K unique characters substring
    public static int totalFruit(int[] fruits) {
        int n = fruits.length;
        int i = 0; int j = 0;
        int maximumFruits = -1;
        Map<Integer,Integer> map = new HashMap<>();
        while(j < n){
            //first put each and every fruit in the map along with it's frequency
            int fruit = fruits[j];
            map.put(fruit, map.getOrDefault(fruit,0)+1);
            //if size of map becomes less than or equal to 2, then  update the answer
            if(map.size() <= 2){
                maximumFruits = Math.max(maximumFruits, j-i+1);
            }
            //if size of map is greater than 2. I mean there are more than 2 types of fruits in the basket
            //then, start removing the fruits from starting from the map. And if at any time, the frequency
            //of that particular fruit becomes 0 then, remove it from the map...and increament the ith idx.
            if(map.size() > 2){
                while(map.size() > 2){
                    int fruitToBeRemoved = fruits[i];
                    map.put(fruitToBeRemoved, map.get(fruitToBeRemoved)-1);
                    if(map.get(fruitToBeRemoved) == 0) map.remove(fruitToBeRemoved);
                    i++;
                }
            }
            //any which ways j will be increamented every time.
            j++;
        }
        return maximumFruits;
    }
}
