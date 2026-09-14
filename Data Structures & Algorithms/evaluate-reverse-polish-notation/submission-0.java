class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (String str : tokens) {
            int left, right;
            if (str.equals("+")) {
                right = stack.removeLast();
                left = stack.removeLast();
                stack.addLast(left + right);
            } else if (str.equals("-")) {
                right = stack.removeLast();
                left = stack.removeLast();
                stack.addLast(left - right);
            } else if (str.equals("*")) {
                right = stack.removeLast();
                left = stack.removeLast();
                stack.addLast(left * right);
            } else if (str.equals("/")) {
                right = stack.removeLast();
                left = stack.removeLast();
                stack.addLast(left / right);
            } else {
                stack.addLast(Integer.parseInt(str));
            }
        }
        return stack.getLast();
    }
}
