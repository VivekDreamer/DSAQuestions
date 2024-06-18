// https://www.geeksforgeeks.org/problems/rectangles-in-a-circle0457/1
class POTD_NumberOfRectanglesInACircle {
    int rectanglesInCircle(int r) {
        int ans = 0;
        for(int i = 1; i < 2 * r; i++){
            for(int j = 1; j < 2 * r; j++){
                //length of diagonal should be less than or equal ot diaameter of circle
                if(i * i + j * j <= 4 * r * r) ans++; 
            }
        }
        return ans;
    }
}
