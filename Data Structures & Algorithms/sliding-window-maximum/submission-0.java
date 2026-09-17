class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        TreeMap<Integer, Integer> tree = new TreeMap<>();

        for (int i = 0; i < k; i++) {
            int val = nums[i];
            tree.put(val, tree.getOrDefault(val, 0) + 1);
        }
        result[0] = tree.lastKey();

        for (int right = k; right < nums.length; right++) {
            int val = nums[right];
            int leftVal = nums[right - k];
            tree.put(val, tree.getOrDefault(val, 0) + 1);
            if (tree.get(leftVal) > 1) {
                tree.compute(leftVal, (key, v) -> v - 1);
            } else {
                tree.remove(leftVal);
            }
            result[right - k + 1] = tree.lastKey();
        }
        return result;
     }
}
