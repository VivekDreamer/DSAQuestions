public class Leetcode_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int minRow = 0;
		    int minCol = 0;
		    int maxRow = matrix.length-1;
		    int maxCol = matrix[0].length-1;
		    int totalElements = matrix.length * matrix[0].length;
		    int count = 0;
		    List<Integer> res = new ArrayList<>();
		    while(count < totalElements) {
			  for(int i = minRow, j = minCol ; j <= maxCol && count < totalElements; j++) {
				    res.add(matrix[i][j]);
				    count++;
			  }  
			  minRow++;
			  for(int i = minRow, j = maxCol; i <= maxRow && count < totalElements; i++) {
				    res.add(matrix[i][j]);
				    count++;
			  }
			  maxCol--;
			  for(int i = maxRow, j = maxCol; j >= minCol && count < totalElements; j--) {
				    res.add(matrix[i][j]);
				    count++;
			  }
			  maxRow--;
			  for(int i = maxRow, j = minCol; i >= minRow && count < totalElements; i--) {
				    res.add(matrix[i][j]);
				    count++;
			  }
			  minCol++;
		}
		return res;
    }
}
