class POTD_FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] ans = image;
        int initialColor = image[sr][sc];
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,-1,0,1};
        dfs(image,ans,sr,sc,delRow,delCol,initialColor,newColor);
        return ans;
    }
    public void dfs(int[][] image, int[][] ans, int row, int col, int[] delRow, int[] delCol, int initialColor, int newColor){
        ans[row][col] = newColor;
        int n = image.length;
        int m = image[0].length;
        for(int i = 0; i < 4; i++){
            int newRow = row + delRow[i];
            int newCol = col + delCol[i];
            if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m &&
            image[newRow][newCol] == initialColor && ans[newRow][newCol] != newColor){
                dfs(image,ans,newRow,newCol,delRow,delCol,initialColor,newColor);
            }
        }
        
    }
}
