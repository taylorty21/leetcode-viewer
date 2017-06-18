public class Solution {
    public String reverseString(String s) {
        char[] arr = s.toCharArray();
        // length - 1
        int i = 0, j = arr.length - 1;
        while (i < j) {
            // j--
            swap(arr, i++, j--);
        }
        // return "[o, l, l, e, h]"
        // return Arrays.toString(arr);
        return new String(arr);
    }

    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}