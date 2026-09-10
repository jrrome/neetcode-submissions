class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> frequency = new HashMap<>();
        int maxLength = 0;
        int start = 0;
        int end = 0;
        boolean advance = true;
        while (end < s.length()) {
            if (advance) {
                frequency.put(s.charAt(end), frequency.getOrDefault(s.charAt(end), 0) + 1);
                advance = false;
            }
            int mostFrequent = Collections.max(frequency.values());
            //    window length 
            if ((end - start + 1) - mostFrequent > k) {
                frequency.computeIfPresent(s.charAt(start), (key, v) -> v - 1);
                start++;
            } else {
                maxLength = Math.max(maxLength, (end - start + 1));
                advance = true;
                end++;
            }
        }
        return maxLength;
    }
}
