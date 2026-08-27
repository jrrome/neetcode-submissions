class Solution {

    public String encode(List<String> strs) {
        /*
        ["Hola Juan", "Adiós Juan"]
        -> [9,10]Hola JuanAdiós Juan
        */
        ArrayList<String> sizes = new ArrayList<>();
        String concat = "";
        for (String str : strs) {
            sizes.add(String.valueOf(str.length()));
            concat = concat.concat(str);
        }
        return new String("[" + String.join(",", sizes) + "]" + concat);
    }

    public List<String> decode(String str) {
        // asume there is no error [,]
        int limit = str.indexOf(']');
        String metadata = str.substring(0, limit + 1);
        String content = str.substring(limit + 1);
        ArrayList<Integer> sizes = new ArrayList<>();
        String count = "";
        for (int i = 0; i < metadata.length(); i++) {
            char c = metadata.charAt(i);
            if (Character.isDigit(c)) count = count.concat(String.valueOf(c));
            if (c == ',') {
                sizes.add(Integer.valueOf(count));
                count = "";
            }
            if (c == ']' && !"".equals(count)) {
                sizes.add(Integer.valueOf(count));
                count = "";
            }
        }
        List<String> result = new ArrayList<>();
        int offset = 0;
        for (int size : sizes) {
            result.add(content.substring(offset, offset + size));
            offset += size;
        }
        return result;
    }
}
