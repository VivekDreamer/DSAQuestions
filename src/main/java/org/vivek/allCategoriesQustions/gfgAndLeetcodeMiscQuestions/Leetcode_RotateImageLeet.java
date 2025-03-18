class Leetcode_RotateImageLeet {
      public void rotate(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = i+1; j < matrix[0].length; j++){
            	if(i!=j) {
            		int tmp = matrix[i][j];
            		matrix[i][j] = matrix[j][i];
            		matrix[j][i] = tmp;
            	}	   
            }
        }
        rowSwap(matrix);
    }
    public void rowSwap(int[][] matrix){
    	for(int i = 0; i < matrix.length; i++) {
    		int start = 0;
        	int end = matrix[0].length-1;
        	while(start < end) {
        		int tmp = matrix[i][start];
        		matrix[i][start] = matrix[i][end];
        		matrix[i][end] = tmp;
        		start++;
        		end--;
        	}
        }
    }
}
