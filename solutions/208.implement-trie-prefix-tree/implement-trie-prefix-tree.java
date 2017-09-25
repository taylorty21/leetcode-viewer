class TrieNode {
    public TrieNode[] children = new TrieNode[26];
    public char val;
    public boolean isWord;
    public TrieNode() {}
    public TrieNode(char val) {
        TrieNode node = new TrieNode();
        node.val = val;
        node.isWord = false;
    }
}

public class Trie {
    
    /** Initialize your data structure here. */
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
        root.val = ' ';
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
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
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            int index = letter - 'a';
            if (temp.children[index] == null) return false;
            temp = temp.children[index];
        }
        return temp.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for (int i = 0; i < prefix.length(); i++) {
            char letter = prefix.charAt(i);
            int index = letter - 'a';
            if (temp.children[index] == null) return false;
            temp = temp.children[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */