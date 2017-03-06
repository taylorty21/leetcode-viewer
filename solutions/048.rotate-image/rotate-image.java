public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // Reverse up and down
        for(int i = 0 ; i < n / 2; i++){
            for(int j = 0; j < n; j++){
                swap(matrix, i, j, n - 1 - i, j);
            }
        }
        // Swap the symmetry (transpose)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }
    
    public void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
        int temp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = temp;
    }
}