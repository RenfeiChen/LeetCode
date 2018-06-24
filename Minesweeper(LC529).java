class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        reveal(click[0], click[1], board);
        return board;
    }
    
    private void reveal(int i, int j, char[][] board) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        if (board[i][j] == 'M') {
            board[i][j] = 'X';
            return;
        }
        if (board[i][j] == 'E') {
            int count = 0;
            for (int ix = -1; ix <= 1; ix++) {
                for (int jx = -1; jx <= 1; jx++) {
                    if (ix == 0 && jx == 0) {
                        continue;
                    }
                    int x = i + ix, y = j + jx;
                    if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
                        continue;
                    }
                    if (board[x][y] == 'M' || board[x][y] == 'X') {
                        count++;
                    }
                }
            }
            if (count > 0) {
                board[i][j] = (char)(count + '0');
            } else {
                board[i][j] = 'B';
                for (int ix = -1; ix <= 1; ix++) {
                    for (int jx = -1; jx <= 1; jx++) {
                        if (ix == 0 && jx == 0) {
                            continue;
                        }
                        int x = i + ix, y = j + jx;
                        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
                            continue;
                        }
                        if (board[x][y] == 'E') {
                            reveal(x, y, board);
                        }
                    }
                }
            }
        }
        
    }
})