class Solution {
    public boolean isPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        while (low < high) {
            char cLow = s.charAt(low);
            char cHigh = s.charAt(high);
            if (!Character.isLetterOrDigit(cLow)) {
        		low++;
        	} else if (!Character.isLetterOrDigit(cHigh)) {
        		high--;
            } else {
                if (Character.toLowerCase(cLow) != Character.toLowerCase(cHigh)) {
                    return false;
                }
                low++;
                high--;
            }
        }
        return true;
    }
}