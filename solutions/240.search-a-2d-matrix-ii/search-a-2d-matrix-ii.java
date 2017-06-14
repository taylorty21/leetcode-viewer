public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        if (matrix.length == 1 && matrix[0].length == 1) return matrix[0][0] == target;
        return search(matrix, target, 0, matrix.length - 1, 0, matrix[0].length - 1);
    }
    
    public boolean search(int[][] matrix, int target, int rMin, int rMax, int cMin, int cMax) {
        // Base Case
        if (rMin < 0 || rMax >= matrix.length || cMin < 0 || cMax >= matrix[0].length || rMin > rMax || cMin > cMax) {
            return false;
        }
        int rMid = rMin + (rMax - rMin) / 2, cMid = cMin + (cMax - cMin) / 2;
        if (matrix[rMid][cMid] == target) {
            return true;
        } else if (matrix[rMid][cMid] > target) {
            return search(matrix, target, rMin, rMid - 1, cMin, cMax) || search(matrix, target, rMin, rMax, cMin, cMid - 1) || search(matrix, target, rMin, rMid - 1, cMin, cMid - 1);
        } else {
            return search(matrix, target, rMid + 1, rMax, cMin, cMax) || search(matrix, target, rMin, rMax, cMid + 1, cMax) || search(matrix, target, rMid + 1, rMax, cMid + 1, cMax);
        }
    }
}