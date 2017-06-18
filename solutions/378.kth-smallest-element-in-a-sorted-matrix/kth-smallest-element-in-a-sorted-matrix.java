public class Solution {
    // Time: O(nlogm) m = max - min
    // Space: O(1)
    public int kthSmallest(int[][] matrix, int k) {
        int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;//[lo, hi)
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0,  j = matrix[0].length - 1;
            for(int i = 0; i < matrix.length; i++) { // row
                while(j >= 0 && matrix[i][j] > mid) j--;
                count += (j + 1); // add the number of elements that is <= than mid
            }
            if(count < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
    
    public int kthSmallest2(int[][] matrix, int k) {
        int n = matrix.length;
        int lo = matrix[0][0], hi = matrix[n - 1][n - 1];
        // Time: O(logm) m = max - min
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int count = getLessEqual(matrix, mid);
            // from left-bottom to right-top can get count <= mid in O(n) time instead of O(nlogn)
            if (count < k) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }
    
    private int getLessEqual(int[][] matrix, int val) {
        int res = 0;
        int n = matrix.length, i = n - 1, j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] > val) i--;
            else {
                res += i + 1;
                j++;
            }
        }
        return res;
    }
}