class Solution {

    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length() || s1.length() == 0) return false;
        int[] appearances = new int[26];
        for (char c : s1.toCharArray()) {
            appearances[c - 'a']++;
        }
        int[] count = new int[26];
        for (int i = 0; i < s1.length() - 1; i++) {
            count[s2.charAt(i) - 'a']++;
        }
        // x x x x
        for (int i = s1.length() - 1; i < s2.length(); i++) {
            count[s2.charAt(i) - 'a']++;
            boolean equals = true;
            for (int j = 0; j < appearances.length; j++) {
                if (appearances[j] != count[j]) {
                    equals = false;
                }
            }
            if (equals) return true;
            count[s2.charAt(i - s1.length() + 1) - 'a']--;
        }
        return false;
        
    }
}
