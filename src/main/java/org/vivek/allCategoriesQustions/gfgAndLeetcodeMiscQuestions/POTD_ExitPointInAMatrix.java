// https://www.geeksforgeeks.org/problems/exit-point-in-a-matrix0905/1
class POTD_ExitPointInAMatrix {
    public int[] FindExitPoint(int n, int m, int[][] matrix) {
        int[] exitPoint = new int[2];
        int i = 0, j = 0;
        // 0->right,1->down,2->left,3->up
        int dir = 0;
        while(true){
            if(matrix[i][j] == 1){
                //changing direction to right
                dir = (dir + 1) % 4;
                matrix[i][j] = 0; //change 1 to 0
            }
            if(dir == 0) j++; //move right
            else if(dir == 1) i++; //move down
            else if(dir == 2) j--; //move left
            else if(dir == 3) i--; //move up
            
            //check if exit point reached
            if(i < 0 || i >= n || j < 0 || j >= m){
                if(dir == 0){
                    exitPoint[0] = i;
                    exitPoint[1] = j-1;
                } else if(dir == 1){
                    exitPoint[0] = i-1;
                    exitPoint[1] = j;
                } else if(dir == 2){
                    exitPoint[0] = i;
                    exitPoint[1] = j+1;
                } else if(dir == 3){
                    exitPoint[0] = i+1;
                    exitPoint[1] = j;
                }
                break;
            }
        }
        return exitPoint;
    }
}
