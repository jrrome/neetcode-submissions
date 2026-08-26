class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, ArrayList<Integer>> hash = new HashMap<Integer, ArrayList<Integer>>();

        for (int i = 0; i < nums.length; ++i) {
            ArrayList<Integer> pos = (ArrayList<Integer>) hash.getOrDefault(nums[i], new ArrayList<Integer>());
            if (pos.isEmpty()) {
                pos.add(i);
                hash.put(nums[i], pos);
            } else {
                pos.add(i);
            }
        }
        int[] result = {0, 0};
        for (int i = 0; i < nums.length; ++i) {     
            int searchFor = target - nums[i];
            ArrayList<Integer> pos = (ArrayList<Integer>) hash.getOrDefault(searchFor, new ArrayList<Integer>());
            if (!pos.isEmpty()) {
                for (int opt : pos) {
                    if (opt != i) {
                        result[0] = i; result[1] = opt;
                        return result;
                    }
                }
            }
        }
        return result;
    }
}
