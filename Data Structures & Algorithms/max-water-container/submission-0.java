class Solution {
    public int maxArea(int[] heights) {
        int left = 0; int right = heights.length - 1;
        int max = 0;
        while (left < right) {
            int volume = Math.min(heights[left], heights[right]) * (right - left);
            if (volume > max) max = volume;
            if (heights[left] > heights[right]) {
                right--;
                while (left < right && heights[right] == heights[right + 1]) right--;
            }
            else {
                left++;
                while (left < right && heights[left] == heights[left - 1]) left++;
            }
        }
        return max;
    }
}
