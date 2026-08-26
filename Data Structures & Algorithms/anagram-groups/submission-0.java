class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hash = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            if (!hash.containsKey(sorted)) {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                hash.put(sorted, list);
            } else {
                List<String> list = hash.get(sorted);
                list.add(str);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (List<String> val : hash.values()) {
            result.add(val);
        }
        return result;
    }
}
