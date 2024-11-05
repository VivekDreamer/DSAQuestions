// https://www.geeksforgeeks.org/problems/rotate-by-90-degree0356/1
public class POTD_RotateBy90 {
    static void rotate(int mat[][]) {
        List<List<Integer>> list = new ArrayList<>();
        int n=mat.length;
        int m=mat[0].length;
        for(int i=n-1; i>=0; i--){
            List<Integer> l = new ArrayList<>();
            for(int j=0; j<m; j++){
                l.add(mat[i][j]);
            }
            list.add(l);
        }
        
        for(int i=0; i<list.size(); i++){
            for(int j=0; j<n; j++){
                mat[j][i]=list.get(i).get(j);
            }
        }
    }
}
