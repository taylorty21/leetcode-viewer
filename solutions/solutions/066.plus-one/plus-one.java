class Solution {
    public int[] plusOne(int[] digits) {
        int length = digits.length - 1;
        int index = length;
        // int carry = 0;
        while (index >= 0) {
            // V1
            // if (carry == 0 && digits[index] < 9) {
            //     digits[index]++;
            //     return digits;
            // } else if (carry != 0 && digits[index] < 9) {
            //     digits[index]++;
            //     return digits;
            // } else if (carry == 0 && digits[index] >= 9) {
            //     carry = 1;
            //     digits[index] = 0;
            //     index--;
            // } else {
            //     carry = 1;
            //     digits[index] = 0;
            //     index--;
            // }
            
            // V2
            // if (digits[index] < 9) {
            //     digits[index]++;
            //     return digits;
            // } else {
            //     carry = 1;
            //     digits[index] = 0;
            //     index--;
            // }
            
            // V3
            if (digits[index] < 9) {
                digits[index]++;
                return digits;
            } else {
                digits[index] = 0;
                index--;
            }
            // V4 Use for loop
        }
        int[] newNumber = new int [length + 2];
        newNumber[0] = 1;
    
        return newNumber;
    }
}