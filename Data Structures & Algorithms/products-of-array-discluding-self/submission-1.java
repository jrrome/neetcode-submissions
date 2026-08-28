class Solution {
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] array = new int[size]; array[0] = 1;

        for (int i = 0; i < size - 1; i++) {
            array[i + 1] = array[i] * nums[i];
        }
        int acum = 1;
        for (int i = size - 1; i > 0; i--) {
            acum *= nums[i];
            array[i - 1] *= acum; 
        }
        return array;
    }
}  
