import heapq


class KthLargest:

    def __init__(self, k: int, nums):
        self.k = k
        if len(nums) <= k:
            self.k_heap = nums
            heapq.heapify(self.k_heap)
        else:
            self.k_heap = nums[0:k]
            heapq.heapify(self.k_heap)
            nums_last = nums[k:]
            for num in nums_last:
                heapq.heappushpop(self.k_heap, num)

    def add(self, val: int):
        if not self.k_heap:
            self.k_heap.append(val)
        elif len(self.k_heap) < self.k:
            self.k_heap.append(val)
            heapq.heapify(self.k_heap)
        elif self.k_heap[0] < val:
            heapq.heappushpop(self.k_heap, val) 
        return self.k_heap[0]


# Your KthLargest object will be instantiated and called as such:
# obj = KthLargest(k, nums)
# param_1 = obj.add(val)
