public class Solution {
    public int myAtoi(String str) {
        // Special cases: leading zeros: 0001 -> 1
        // floating point num
        // negative num: -xxx
        // overflow
        // not a num
        
        // white spaces
        // + 
        // -+2 -> 0
        // "9223372036854775809" larger than long
        long res = 0;
        long max = Integer.MAX_VALUE + 1;
        int sign = 1, index = 0;
        // skip white spaces
        while (index < str.length() && str.charAt(index) == ' ' ) {
            index++;
        }
        // if (index < str.length() && str.charAt(index) == '-') {
        //     flag = true;
        //     sign++;
        // }
        // if (sign < str.length() && str.charAt(sign) == '+') {
        //     sign++;
        //     if (flag) {
        //         return 0;
        //     }
        // }
        // handle sign
        if(index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-')){
            sign = str.charAt(index) == '+' ? 1 : -1;
            index ++;
        }
    
        for (int i = index; i < str.length(); i++) {
            int digit = str.charAt(i) - '0';
            if (digit >= 0 && digit <= 9) {
                
                // check if total will be overflow after 10 times and add digit
                if(Integer.MAX_VALUE / 10 < res || Integer.MAX_VALUE / 10 == res && Integer.MAX_VALUE % 10 < digit)
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                res = res * 10 + digit;
            } else {
                // stop when there is non-digit character
                break;
            }
        }
        // if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        // if (res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) res * sign;
    }
}