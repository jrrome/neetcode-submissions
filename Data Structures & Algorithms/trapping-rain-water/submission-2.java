class Solution {
    public int trap(int[] height) {
        int[] left_max = new int[height.length];
        int[] right_max = new int[height.length];
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
            }
            left_max[i] = max;
        }
        max = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] > max) {
                max = height[i];
            }
            right_max[i] = max;
        }
        int acum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int volume = Math.min(left_max[i - 1], right_max[i + 1]) - height[i];
            if (volume > 0) {
                acum += volume;
            }
        }
        return acum;
    }
}
