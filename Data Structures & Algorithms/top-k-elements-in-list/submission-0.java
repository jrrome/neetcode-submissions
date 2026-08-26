class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int num : nums) {
            hash.merge(num, 1, Integer::sum);
        }
        int[][] matrix = new int[hash.size()][2];
        int i = 0;
        for (var entry : hash.entrySet()) {
            matrix[i][0] = entry.getKey();
            matrix[i][1] = entry.getValue();
            i++;
        }
        Arrays.sort(matrix, (a, b) -> Integer.compare(b[1], a[1]));
        int[] result = new int[k];
        for (int j = 0; j < k; j++) {
            result[j] = matrix[j][0];
        }
        return result;
    }
}
