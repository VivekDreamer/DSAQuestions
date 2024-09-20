// https://www.geeksforgeeks.org/problems/facing-the-sun2126/1
class POTD_FacingTheSun {
    // Returns count buildings that can see sunlight
    public int countBuildings(int[] height) {
        int max = height[0];
        int sun = 1;
        for(int i=1; i<height.length; i++){
            
            if(height[i]>max){
                max = height[i];
                sun++;
            }
        }
        
        return sun;
    }
}
