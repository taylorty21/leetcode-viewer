class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length() || needle.length() == haystack.length() && !needle.equals(haystack)) return -1;
        if (needle.length() == haystack.length() && needle.equals(haystack)) return 0;
        int length = needle.length();
        for (int i = 0; i < haystack.length() - length + 1; i++) {
            if (haystack.substring(i, i + length).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
    
    public int strStr2(String haystack, String needle) {
      for (int i = 0; ; i++) {
        for (int j = 0; ; j++) {
          if (j == needle.length()) return i;
          if (i + j == haystack.length()) return -1;
          if (needle.charAt(j) != haystack.charAt(i + j)) break;
        }
      }
    }
}