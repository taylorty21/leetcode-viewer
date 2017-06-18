public class Solution {
    public int strStr(String haystack, String needle) {
        // Corner case: both ""
        // one of them is ""
        if (haystack.equals(needle) || needle.equals("")) {
            return 0;
        }
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            for (int j = 0; j < needle.length(); j++) {
                // Pay attention to the i + j index here
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
                if (j == needle.length() - 1 && needle.charAt(j) == haystack.charAt(i + j)) {
                    return i;
                }
            }
        }
        return -1;
    }
}