class Solution {
    public int countBattleships(char[][] board) {
        int n = board.length, result = 0;
        if (n == 0) {
            return 0;
        }
        int m = board[0].length;
        if (m == 0) {
            return 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'X') {
                    if (i == 0 || board[i - 1][j] != 'X') {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}