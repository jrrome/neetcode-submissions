class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = prices.length - 1;
        int max = 0;
        int leftMin = prices[left];
        int rightMax = prices[right];
        while (left < right) {
            max = Math.max(max, prices[right] - prices[left]);
            if (prices[left] > prices[right]) {
                left++;
                max = Math.max(max, prices[left] - leftMin);
                leftMin = Math.min(leftMin, prices[left]);
            } else {
                right--;
                max = Math.max(max, rightMax - prices[right]);
                rightMax = Math.max(rightMax, prices[right]);
            }
        }
        return max;
    }
}
