package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

import java.util.ArrayList;
import java.util.Collections;
// https://www.geeksforgeeks.org/problems/buy-maximum-stocks-if-i-stocks-can-be-bought-on-i-th-day/1
public class POTD_BuyMaximumStocksIfiStocksCanBeBoughtOnithDay {

    public static int buyMaximumProducts(int n, int k, int[] prices){
        ArrayList<Pair> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            arr.add(new Pair(prices[i], i+1));
        }
        Collections.sort(arr);
        int ans = 0;
        for(int i = 0; i < n; i++){
            int units = Math.min(arr.get(i).quantity, arr.get(i).cost/k);
            k -= (arr.get(i).cost * units);
            ans+=units;
        }
        return ans;
    }

    static class Pair implements Comparable<Pair> {
        int cost, quantity;
        Pair(int _cost, int _quantity){
            this.cost = _cost;
            this.quantity = _quantity;
        }
        @Override
        public int compareTo(Pair other) {
            return this.cost - other.cost;
        }
    }
    
}
