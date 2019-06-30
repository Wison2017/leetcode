import collections


class Trie:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = collections.defaultdict()
        self.END_OF_WORD = '*'

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        if word is None or len(word) == 0:
            return
        node = self.root
        for char in word:
            node = node.setdefault(char, collections.defaultdict())
        node[self.END_OF_WORD] = None

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        if word is None or len(word) == 0:
            return False
        node = self.root
        for char in word:
            if char not in node:
                return False
            node = node[char]
        if self.END_OF_WORD in node:
            return True
        return False

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.

        """
        if prefix is None or len(prefix) == 0:
            return False
        node = self.root
        for char in prefix:
            if char not in node:
                return False
            node = node[char]
        return True

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
