class Solution {
    public boolean isAnagram2(String s, String t) {
        int[] map = new int[26];
        if (s.length() != t.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
            map[t.charAt(i) - 'a']--;
        }
            
        for (int num: map) {
            if (num != 0) return false;
        }
        return true;
    }
    
    public boolean isAnagram(String s, String t) {
        if(s.length() == 0 && t.length() == 0) return true;
        if(s.length() != t.length()) return false;
        int[] map = new int[256];
        for(char c : s.toCharArray()){
            map[c]++;
        }
        for(char a : t.toCharArray()){
            if(map[a] <= 0) return false;
            map[a]--;
        }
        return true;
    }
}