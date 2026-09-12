class Solution {
    public String minWindow(String s, String t) {
        String result = "";
        if (t.length() > s.length())
            return result;
        int min = s.length() + 1;

        HashMap<Character, Integer> target = new HashMap<>();
        HashMap<Character, Integer> count = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            target.put(t.charAt(i), target.getOrDefault(t.charAt(i), 0) + 1);
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);
        }

        // check
        boolean valid = true;
        for (var entry : target.entrySet()) {
            if (count.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                valid = false;
                break;
            }
        }

        if (valid) {
            result = s.substring(0, t.length());
            min = t.length();
        } 

        int left = 0;
        for (int right = t.length(); right < s.length(); right++) {
            count.put(s.charAt(right), count.getOrDefault(s.charAt(right), 0) + 1);

            char leftChar = s.charAt(left);
            while ((!target.containsKey(leftChar) // does not contain key
                || (target.get(leftChar) - count.get(leftChar) < 0))
                && left < right) 
            {
                count.computeIfPresent(leftChar, (k, v) -> v - 1);
                left++;
                leftChar = s.charAt(left);
            }

            valid = true;
            for (var entry : target.entrySet()) {
                if (count.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                    valid = false;
                    break;
                }
            }
            if (valid && (right + 1 - left) < min) {
                min = right + 1 - left;
                result = s.substring(left, right + 1);
            }
        }
        return result;
    }
}
