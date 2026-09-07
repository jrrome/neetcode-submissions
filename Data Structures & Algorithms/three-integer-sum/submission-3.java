class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        // -3 -1 0 0 1 3 4
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int target = -nums[i];
            int left = i + 1; int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    List<Integer> triplet = new ArrayList<>(Arrays.asList(-target, nums[left], nums[right]));
                    result.add(triplet);
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
