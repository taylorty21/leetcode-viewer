public class Solution {
    
    public String reverseWords(String str) {
        int begin = 0; // end of last word
        int end = 0;
        int i = 0;
        char[] s = str.toCharArray();
        while (i < s.length && s[i] == ' ') i++; //skip leading whitespace
        while (i < s.length) {
            int j = i;
            end = begin;
            while (j < s.length && s[j] != ' ') {s[end] = s[j]; ++end; ++j;}
            // s[j] == ' ' 
            reverse(s, begin, end); //reverses [begin, end-1]
            while (j < s.length && s[j] == ' ') ++j;
            // s[j] != ' '
            i = j;
            if (end < s.length) s[end] = ' ';
            begin = end+1;
        }
        reverse(s, 0, end);
        return new String(s).substring(0, end);
    }
    
    private void reverse(char[] s, int begin, int end) {
        --end;
        while(begin < end) {
            char temp = s[begin];
            s[begin] = s[end];
            s[end] = temp;
            ++begin;
            --end;
        }
    }
    
    public String reverseWords3(String s) {
        if (s == null) return null;
        char[] a = s.toCharArray();
        int n = a.length;

        // step 1. reverse the whole string
        reverse(a, 0, n - 1);
        // step 2. reverse each word
        reverseWords(a, n);
        // step 3. clean up spaces
        return cleanSpaces(a, n);
    }
 
    void reverseWords(char[] a, int n) {
        int i = 0, j = 0;

        while (i < n) {
            while (i < j || i < n && a[i] == ' ') i++; // skip spaces
            while (j < i || j < n && a[j] != ' ') j++; // skip non spaces
            reverse(a, i, j - 1);                      // reverse the word
        }
    }
    
    String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;

        while (j < n) {
          while (j < n && a[j] == ' ') j++;             // skip spaces
          while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
          while (j < n && a[j] == ' ') j++;             // skip spaces
          if (j < n) a[i++] = ' ';                      // keep only one space
        }

        return new String(a).substring(0, i);
    }
    
    // reverse a[] from a[i] to a[j]
    private void reverse2(char[] a, int i, int j) {
        while (i < j) {
          char t = a[i];
          a[i++] = a[j];
          a[j--] = t;
        }
    }
    
    public String reverseWords2(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
    
    public String reverseWords4(String s) {
        if (s == null || s.length() == 0) return "";
        String[] array = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = array.length - 1; i >= 0; --i) {
            if (!array[i].equals("")) {
                sb.append(array[i]).append(" ");
            }
        }
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);                       
    }
}