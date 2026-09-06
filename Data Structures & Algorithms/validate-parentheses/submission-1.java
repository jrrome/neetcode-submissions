class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(', '{', '[' -> stack.push(c);
                case ')' -> {
                    if (stack.isEmpty() || stack.pop() != '(') return false;
                }
                case '}' -> {
                    if (stack.isEmpty() || stack.pop() != '{') return false;
                }
                case ']' -> {
                    if (stack.isEmpty() || stack.pop() != '[') return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
