class MyQueue(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.input = []
        self.output = []
        

    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        """
        self.input.append(x)

    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        if self.output:
            return self.output.pop()
        elif self.input:
            while self.input:
                self.output.append(self.input.pop())
            return self.output.pop()
        return None

    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        if self.output:
            return self.output[-1]
        elif self.input:
            while self.input:
                self.output.append(self.input.pop())
            return self.output[-1]
        return None

    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        return not self.input and not self.output


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
