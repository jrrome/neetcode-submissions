class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.') {
                    int value = board[row][col] - '1';
                    int box = (row / 3) * 3 + (col / 3);
                    if (rows[row][value] || cols[col][value] || boxes[box][value]) return false;
                    rows[row][value] = true;
                    cols[col][value] = true;
                    boxes[box][value] = true;
                }
            }
        }
        return true;
    }
}
