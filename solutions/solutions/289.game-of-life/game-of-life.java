class Solution {
    int[][] dir = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int live = 0;
                for (int[] d: dir) {
                    if (d[0] + i < 0 || d[0] + i >= board.length || d[1] + j < 0 || d[1] + j >= board[0].length) continue;
                    if (board[d[0] + i][d[1] + j] == 1 || board[d[0] + i][d[1] + j] == 2) live++;
                }
                // In the beginning, every 2nd bit is 0;
                // So we only need to care about when will the 2nd bit become 1.
                if (board[i][j] == 0 && live == 3) board[i][j] = 3; // Make the 2nd bit 1: 01 ---> 11
                if (board[i][j] == 1 && (live < 2 || live > 3)) board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 10
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] %= 2;
            }
        }
    }
}