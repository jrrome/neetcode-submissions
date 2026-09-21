class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Integer[] indexes = new Integer[position.length];
        for (int i = 0; i < position.length; i++) {
            indexes[i] = i;
        }
        Arrays.sort(indexes, Comparator.comparingInt(i -> position[i]));

        ArrayDeque<Double> stack = new ArrayDeque<>();

        for (int i = 0; i < indexes.length; i++) {
            int index = indexes[i];
            double time = (double) (target - position[index]) / speed[index];
            while (!stack.isEmpty() && time >= stack.getLast()) {
                stack.removeLast();
            } 
            stack.addLast(time);
        }
        return stack.size();
    }
}
