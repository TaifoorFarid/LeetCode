// https://leetcode.com/problems/word-search/
// 138 ms
class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (searchWord(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean searchWord(char[][] board, String word, int i, int j, int k) {
        if (k == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(k)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '#';

        boolean ans =  searchWord(board, word, i, j + 1, k + 1) ||
                searchWord(board, word, i + 1, j, k + 1) ||
                searchWord(board, word, i, j - 1, k + 1) ||
                searchWord(board, word, i - 1, j, k + 1);

        board[i][j] = temp;

        return ans;
    }
}
