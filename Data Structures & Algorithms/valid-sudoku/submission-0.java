class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] area = new boolean[9];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        // board[i * 3 + x][j * 3 + y]
                        if (board[i*3+x][j*3+y] == '.') continue;
                        int val = Character.getNumericValue(board[i*3+x][j*3+y]);
                        if (area[val - 1]) return false;
                        area[val - 1] = true;
                    }
                }
                Arrays.fill(area, false);
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int val = Character.getNumericValue(board[i][j]);
                if (area[val - 1]) return false;
                area[val - 1] = true;
            }
            Arrays.fill(area, false);
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') continue;
                int val = Character.getNumericValue(board[j][i]);
                if (area[val - 1]) return false;
                area[val - 1] = true;
            }
            Arrays.fill(area, false);
        }
        return true;
    }
}
