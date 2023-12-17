package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

//https://leetcode.com/problems/design-a-food-rating-system/
class Leetcode_DesignFoodSystem {

    private Map<String,Integer> food_ratings = new HashMap<>();
    private Map<String,String> food_cuisine = new HashMap<>();
    private Map<String,TreeSet<Pair>> cuisine_rating_food = new HashMap<>();

    public Leetcode_DesignFoodSystem(String[] foods, String[] cuisines, int[] ratings) {
        for(int i = 0; i < foods.length; i++){
            food_ratings.put(foods[i],ratings[i]);
            food_cuisine.put(foods[i],cuisines[i]);
            cuisine_rating_food
                .computeIfAbsent(cuisines[i], k -> new TreeSet<>((a,b)->
                    {
                        int compareByRating = Integer.compare(a.getRating(),b.getRating());
                        if(compareByRating == 0) return a.getFood().compareTo(b.getFood());
                        return compareByRating;
                    }))
                .add(new Pair(-ratings[i],foods[i]));
        }
    }
    
    public void changeRating(String food, int newRating) {
        String cuisineName = food_cuisine.get(food);
        TreeSet<Pair> cuisineSet = cuisine_rating_food.get(cuisineName);
        Pair oldElement = new Pair(-food_ratings.get(food),food);
        cuisineSet.remove(oldElement);
        food_ratings.put(food,newRating);
        cuisineSet.add(new Pair(-newRating,food));
    }
    
    public String highestRated(String cuisine) {
        Pair highestRated = cuisine_rating_food.get(cuisine).first();
        return highestRated.getFood();
    }
    
    class Pair{
        Integer rating;
        String food;
        Pair(){}
        Pair(Integer _rating, String _food){
            this.rating = _rating;
            this.food = _food;
        }
        Integer getRating(){
            return this.rating;
        }
        String getFood(){
            return this.food;
        }
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
