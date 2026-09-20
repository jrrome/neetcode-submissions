class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int nCols = matrix[0].length;
        int nRows = matrix.length;
        int leftBound = 0;
        int rightBound = nRows - 1;
        
        while (leftBound <= rightBound) {
            int mid = leftBound + (rightBound - leftBound) / 2;
            int val = matrix[mid][0];
            if (val == target) {
                return true;
            } else if (target < val) {
                rightBound = mid - 1;
            } else {
                leftBound = mid + 1;
            }
        }

        int selectedRow = rightBound;
        if (selectedRow == -1) return false;

        leftBound = 0;
        rightBound = nCols - 1;

        while (leftBound <= rightBound) {
            int mid = leftBound + (rightBound - leftBound) / 2;
            int val = matrix[selectedRow][mid];
            if (val == target) {
                return true;
            } else if (target < val) {
                rightBound = mid - 1;
            } else {
                leftBound = mid + 1;
            }
        }
        return false;
    }
}
