class Solution {
    public int[][] matrixReshape2(int[][] nums, int r, int c) {
        int m = nums.length, n = nums[0].length;
        if (r * c > m * n) {
            return nums;
        }
        int[][] res = new int[r][c];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int pos = i + j * n;
                res[pos / c][pos % c] = nums[j][i];
            }
        }
        return res;
    }
    
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int n = nums.length, m = nums[0].length;
        if (r * c != m * n) {
            return nums;
        }
        int[][] res = new int[r][c];
        for (int i = 0; i < r * c; i++) {
            res[i / c][i % c] = nums[i / m][i % m];
        }
        return res;
    }
}