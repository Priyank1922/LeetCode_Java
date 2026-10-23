class Solution {

    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int rows = board.length;
        int cols = board[0].length;

        // First and last row
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O')
                DFS(board, 0, j);

            if (board[rows - 1][j] == 'O')
                DFS(board, rows - 1, j);
        }


        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O')
                DFS(board, i, 0);

            if (board[i][cols - 1] == 'O')
                DFS(board, i, cols - 1);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void DFS(char[][] board, int i, int j) {

        if (i < 0 || i >= board.length ||
            j < 0 || j >= board[0].length ||
            board[i][j] != 'O') {
            return;
        }

        board[i][j] = '#';

        DFS(board, i + 1, j);
        DFS(board, i - 1, j);
        DFS(board, i, j + 1);
        DFS(board, i, j - 1);
    }
}