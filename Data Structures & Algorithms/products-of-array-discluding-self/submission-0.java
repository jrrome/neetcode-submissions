class Solution {
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] forward = new int[size]; Arrays.fill(forward, 1);
        int[] backward = new int[size]; Arrays.fill(backward, 1);

        for (int i = 0; i < size - 1; i++) {
            forward[i + 1] = forward[i] * nums[i];
        }
        for (int i = size - 1; i > 0; i--) {
            backward[i - 1] = backward[i] * nums[i];
        }
        for (int i = 0; i < size; i++) {
            nums[i] = forward[i] * backward[i];
        }
        return nums;
    }
}  
