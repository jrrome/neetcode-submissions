class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> exists = new HashSet<>();
        for (int num : nums) {
            exists.add(num);
        }
        ArrayList<Integer> starters = new ArrayList<>();
        for (int num : nums) {
            if (!exists.contains(num - 1)) {
                starters.add(num);
            }
        }
        int max = 0;
        for (Integer start : starters) {
            int count = 1;
            while (exists.contains(start + count)) {
                count++;
            }
            if (count > max) max = count;
        }
        return max;
    }
}
