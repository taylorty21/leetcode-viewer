class TrieNode {
    public TrieNode[] children = new TrieNode[26];
    public char val;
    public boolean isWord;
    public TrieNode() {}
    public TrieNode(char val) {
        TrieNode node = new TrieNode();
        node.isWord = false;
    }
}

public class WordDictionary {
    private TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
        root.val = ' ';
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            int index = letter - 'a';
            if (temp.children[index] == null) {
                temp.children[index] = new TrieNode(letter);
            }
            temp = temp.children[index];
        }
        temp.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }
    
    private boolean match(char[] chs, int index, TrieNode node) {
        if (index == chs.length) {
            // if (node.isWord) return true;
            // return false;
            return node.isWord;
        }
        char letter = chs[index];
        if (letter == '.') {
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null) {
                    if (match(chs, index + 1, node.children[i])) {
                        return true;
                    }
                }
            }
        } else {
            int pos = letter - 'a';
            return node.children[pos] != null && match(chs, index + 1, node.children[pos]);
            // This is incorrect
            // All the node.val is null except the root
            // if (letter == node.val) {
            //     return node.children[pos] != null && match(chs, index + 1, node.children[pos]);
            // }
        }
        return false;
    }
    
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */