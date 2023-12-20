package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

// https://leetcode.com/problems/buy-two-chocolates/
public class Leetcode_BuyTwoChocolates {
    public int buyChoco(int[] prices, int money) {
        int minPrice = Integer.MAX_VALUE;
        int secondMinPrice = Integer.MAX_VALUE;
        for(int price : prices){
            if(price < minPrice) {
                secondMinPrice = minPrice;
                minPrice = price;
            } else {
                secondMinPrice = Math.min(price,secondMinPrice);
            }
        }
        if(minPrice + secondMinPrice > money) return money;
        return money - (minPrice + secondMinPrice);
    }
}
