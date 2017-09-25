class Solution {
    public String multiply(String num1, String num2) {

        int len1 = num1.length(), len2 = num2.length();
        int[] result = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int mult = (num2.charAt(j) - '0') * (num1.charAt(i) - '0');
                
                int posLow = i + j + 1;
                int posHigh = i + j;
                mult += result[posLow];
                result[posLow] = mult % 10;
                result[posHigh] += mult / 10;
            } 
        }
        StringBuilder sb = new StringBuilder();
        for (int res: result) {
            if (!(sb.length() == 0 && res == 0)) sb.append(res);
        }
        return (sb.length() == 0)? "0" : sb.toString(); // 0 is a special case here
    }
}