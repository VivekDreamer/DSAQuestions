package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

// https://leetcode.com/problems/flood-fill/
public class Leetcode_FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor) return image;
        fillColor( image, image[sr][sc], sr, sc, newColor);
        return image;
       }
        public void fillColor(int[][] image, int oldColor, int sr, int sc, int newColor) {
           
            if(sc<0 || sr<0 || sr >= image.length || sc >= image[0].length || image[sr][sc] !=          oldColor) return;
            
            image[sr][sc] = newColor;
            fillColor( image, oldColor, sr-1, sc, newColor);
            fillColor( image, oldColor, sr+1, sc, newColor);
            fillColor( image, oldColor, sr, sc-1, newColor);
            fillColor( image, oldColor, sr, sc+1, newColor);
            
        }
}
