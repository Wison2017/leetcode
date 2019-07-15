class DLinkedNode():
    def __init__(self):
        self.key = 0
        self.value = 0
        self.pre = None
        self.next = None


class LRUCache():
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.head = DLinkedNode()
        self.tail = DLinkedNode()
        self.head.next = self.tail
        self.tail.pre = self.head
        self.dit = {}

    def _addNode(self, new_node):
        next = self.head.next

        self.head.next = new_node
        new_node.pre = self.head
        new_node.next = next
        next.pre = new_node

    def _removeNode(self, delete_node):
        pre = delete_node.pre
        next = delete_node.next
        pre.next = next
        next.pre = pre

    def _move_to_head(self, node):
        self._removeNode(node)
        self._addNode(node)

    def _delete_tail_node(self):
        node = self.tail.pre
        self._removeNode(node)
        return node

    def get(self, key: int) -> int:
        if key in self.dit:
            node = self.dit[key]
            self._move_to_head(node)
            return node
        return -1

    def put(self, key: int, value: int) -> None:
        if key in self.dit:
            node = self.dit[key]
            node.value = value
            self._move_to_head(node)
        else:
            new_node = DLinkedNode()
            new_node.key = key
            new_node.value = value
            if len(self.dit) >= self.capacity:
                deleted_node = self._delete_tail_node()
                self.dit.pop(deleted_node.key)
            self._addNode(new_node)
            self.dit[key] = new_node

n = DLinkedNode()
n.key = 1
n.value = 1