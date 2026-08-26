class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        ArrayList<ArrayList<Integer>> array = new ArrayList<>(nums.length + 1);
        for (int i = 0; i < nums.length + 1; i++) {
            array.add(new ArrayList<Integer>());
        }
        for (int num : nums) {
            int occurrences = hash.merge(num, 1, Integer::sum);
        }
        for (var entry : hash.entrySet()) {
            var list = array.get(entry.getValue());
            list.add(entry.getKey());
        }
        int[] result = new int[k];
        int count = 0;
        for (int i = nums.length; i >= 0; i--) {
            for (int j : array.get(i)) {
                result[count] = j;
                count++;
                if (count == k)
                    return result;
            }
        }
        return result;
    }
}
