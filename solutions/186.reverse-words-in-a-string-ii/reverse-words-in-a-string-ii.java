public class Solution {
    // Example: hi!, hello world!, a b, a b c d
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        int head = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverse(s, head, i - 1);
                head = i + 1;
            }
        }
        reverse(s, head, s.length - 1);
        
        // if (s == null || s.length == 0) return;
        // for (int i = 0; i < s.length; i++) {
        //     if (s[i] == ' ') break;
        //     if (i == s.length - 1 && s[i] != ' ') return;
        // }
        // reverse(s, 0, s.length - 1);
        // int i = 0, j = 0;
        // while (i < s.length && j < s.length) {
        //     if (s[j] == ' ') {
        //         reverse(s, i, j - 1);
        //         i = j + 1;
        //     } else if (j == s.length - 1 && s[j] != ' ') {
        //         reverse(s, i, j);
        //     }
        //     j++;
        // }
    }
    
    // reverse a[] from a[i] to a[j]
    private void reverse(char[] a, int i, int j) {
        while (i < j) {
          char t = a[i];
          a[i++] = a[j];
          a[j--] = t;
        }
    }
}