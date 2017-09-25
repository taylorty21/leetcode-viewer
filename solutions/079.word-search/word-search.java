class Solution {
    static boolean[][] visited;
    
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (exist(board, i, j, 0, word)) return true;
                }
            }
        }
        return false;
    }
    
    public boolean exist(char[][] board, int i, int j, int index, String word) {
        if (index == word.length()) {
            return true;
        }
        
        if (i >= board.length || i < 0 || j < 0 || j >= board[i].length || board[i][j] != word.charAt(index) || visited[i][j])      
            return false;
        visited[i][j] = true;
        if (exist(board, i + 1, j, index + 1, word) ||
            exist(board, i, j + 1, index + 1, word) ||
            exist(board, i - 1, j, index + 1, word) ||
            exist(board, i, j - 1, index + 1, word)) return true;
        visited[i][j] = false; // Mark visited 2, unmark when backtrack
        return false;
    }
}