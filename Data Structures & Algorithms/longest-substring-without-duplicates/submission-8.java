class Solution {
    public int lengthOfLongestSubstring(String s) {
        // "zxyzoyz"
        int start = -1;
        int maxLength = 0;
        HashMap<Character, Integer> lastSeen = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            // duplicate
            if (lastSeen.containsKey(s.charAt(i))) {
                start = Math.max(lastSeen.put(s.charAt(i), i), start);
            } else {
                lastSeen.put(s.charAt(i), i);
            }
            maxLength = Math.max(i - start, maxLength);
        }
        return maxLength;
    }
}
