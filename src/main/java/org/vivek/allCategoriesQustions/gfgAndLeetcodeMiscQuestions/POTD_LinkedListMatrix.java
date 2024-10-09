// https://www.geeksforgeeks.org/problems/linked-list-matrix/1
class Node{
   int data;
   Node right,down;
   Node(int data){
       this.data = data;
       right = null;
       down = null;
   }
}

public class POTD_LinkedListMatrix {
    static Node construct(int arr[][]) {
        int n = arr.length;
        Node[][] matrix = new Node[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                matrix[i][j] = new Node(arr[i][j]);
            }
        }
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(j<n-1)
                    matrix[i][j].right = matrix[i][j+1];
                if(i<n-1)
                    matrix[i][j].down = matrix[i+1][j];
            }
        }
        
        return matrix[0][0];
    }
}
