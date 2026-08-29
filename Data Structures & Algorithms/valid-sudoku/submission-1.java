class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                int value = board[row][col] - '1';
                if (value < 0 || value > 9) continue;
                if (rows[row][value]) return false;
                rows[row][value] = true;
                if (cols[col][value]) return false;
                cols[col][value] = true;
                int box = (row / 3) * 3 + (col / 3);
                if (boxes[box][value]) return false;
                boxes[box][value] = true;
            }
        }
        return true;
    }
}
