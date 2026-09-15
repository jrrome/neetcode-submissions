class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.addLast(temperatures[0]);

        for (int i = 1; i < temperatures.length; i++) {
            for (int j = 1; !stack.isEmpty() && temperatures[i] > stack.getLast(); j++) {
                stack.removeLast();
                while((i - j) > 0 && result[i - j] != 0) j++;
                result[i - j] = j;
            }
            stack.addLast(temperatures[i]);
        }
        return result;
    }
}
