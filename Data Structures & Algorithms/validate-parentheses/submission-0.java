class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(': {
                    stack.push(c);
                    break;
                }
                case ')': {
                    if (stack.isEmpty() || stack.peek() != '(') return false;
                    stack.pop();
                    break;
                }
                case '{': {
                    stack.push(c);
                    break;
                }
                case '}': {
                    if (stack.isEmpty() || stack.peek() != '{') return false;
                    stack.pop();
                    break;
                }
                case '[': {
                    stack.push(c);
                    break;
                }
                case ']': {
                    if (stack.isEmpty() || stack.peek() != '[') return false;
                    stack.pop();
                    break;
                }
                default: break;
            }
        }
        return stack.isEmpty();
    }
}
