class Solution {
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j] && exist(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }
    
    public boolean exist(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) return true;
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || board[i][j] != word.charAt(index) || visited[i][j]) return false;
        visited[i][j] = true;
        // board[i][j] ^= 256;
        if (exist(board, word, i + 1, j, index + 1) || 
                         exist(board, word, i - 1, j, index + 1) || 
                         exist(board, word, i, j + 1, index + 1) || 
                         exist(board, word, i, j - 1, index + 1)) return true;
        visited[i][j] = false;
        // board[i][j] ^= 256; // to save space
        return false;
    }
}