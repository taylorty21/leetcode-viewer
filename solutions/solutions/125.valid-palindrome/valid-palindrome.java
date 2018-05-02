class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) return true;
        int i = 0, j = s.length() - 1;
        char start = s.charAt(i), end = s.charAt(j);
        while (i < j) {
            start = s.charAt(i);
            end = s.charAt(j);
            if (!Character.isLetterOrDigit(start)) {
                i++;
            } else if (!Character.isLetterOrDigit(end)) {
                j--;
            } else {
                if (Character.toLowerCase(start) != Character.toLowerCase(end)) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}