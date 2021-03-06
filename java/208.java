public class Trie {
    private TrieNode root = null;
    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode();
        root.setVal(' ');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0)
            return;
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.getChildren()[c - 'a'] == null) {
                node.getChildren()[c - 'a'] = new TrieNode(c);
            }
            node = node.getChildren()[c - 'a'];
        }
        node.setIs_word(true);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null || word.length() == 0)
            return false;
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.getChildren()[c - 'a'] == null) return false;
            else node = node.getChildren()[c - 'a'];
        }
        if (node.isIs_word() == true) return true;
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) return false;
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (node.getChildren()[c - 'a'] == null) return false;
            else node = node.getChildren()[c - 'a'];
        }
        return true;
    }
}

class TrieNode {
    private boolean is_word = false;
    private char val;
    private TrieNode[] children = new TrieNode[26];
    public TrieNode() {
    }
    public TrieNode(char c) {
        this.val = c;
    }

    public boolean isIs_word() {
        return is_word;
    }

    public void setIs_word(boolean is_word) {
        this.is_word = is_word;
    }

    public char getVal() {
        return val;
    }

    public void setVal(char val) {
        this.val = val;
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public void setChildren(TrieNode[] children) {
        this.children = children;
    }

}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

